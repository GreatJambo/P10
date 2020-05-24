import java.util.*;

public class leetcode {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt()/10,m=in.nextInt();
        int [][]thing=new int[m+1][5];
        for(int i=1;i<=m;i++)
        {
            thing[i][0]=in.nextInt()/10;
            thing[i][1]=in.nextInt();
            thing[i][2]=in.nextInt();
        }
        for(int i=0;i<=m;i++)
        {
            if(thing[i][2]!=0)
            {
                thing[i][3]=thing[thing[i][2]][0];
                thing[i][4]=thing[thing[i][2]][1];
            }
        }
        Arrays.sort(thing,new Comparator<int[]>(){
            public int compare(int[]a,int[]b){
                if(a[0]==b[0])
                    return b[1]-a[1];
                else return a[0]-b[0];
            }
        });
        int [][]price=new int[n+1][m+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(thing[j][2]==0)//主件
                {
                    if(i>=thing[j][0])
                    {
                        price[i][j]=Math.max(price[i][j-1],price[i-thing[j][0]][j-1]+thing[j][0]*thing[j][1]);
                    }
                    else
                        price[i][j]=price[i][j-1];
                }
                else{
                    if(i>=thing[j][0]+thing[j][3])
                    {
                        price[i][j]=Math.max(price[i][j-1],price[i-thing[j][0]-thing[j][3]][j-1]+thing[j][0]*thing[j][1]+thing[j][3]*thing[j][4]);
                    }
                    else price[i][j]=price[i][j-1];
                }
            }
        }
        System.out.print(price[n][m]*10);
    }
}
