
import java.util.*;
public class bankeralgo
{
    public void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of processes");
        int p=sc.nextInt();
        System.out.println("Enter number of resources");
        int r=sc.nextInt();
        int max[][]=new int[p][r];
        int av[]=new int[r];
        int alloc[][]=new int[p][r];
        int need[][]=new int[p][r];
        String safe="";
        int flag[]=new int[p];
        int c=0;
        boolean point[]=new boolean[p];
        for(int i=0;i<r;i++)
        {
            flag[i]=0;
        }
        for(int i=0;i<p;i++)
        {
            point[i]=false;
        }
        System.out.println("Enter the total number of available resources of each type");
        for(int i=0;i<r;i++)
        {
            av[i]=sc.nextInt();
        }
        System.out.println("Enter the maximum resource need of each process");
        for(int i=0;i<p;i++)
        {
            for(int j=0;j<r;j++)
                max[i][j]=sc.nextInt();
        }
        System.out.println("Enter the number of resources allocated to each process");
        for(int i=0;i<p;i++)
        {
            for(int j=0;j<r;j++)
                alloc[i][j]=sc.nextInt();
        }
        for(int i=0;i<p;i++)
        {
            for(int j=0;j<r;j++)
                need[i][j]=max[i][j]-alloc[i][j];
        }
        for(int i=0;i<p;i++)
        {
            flag[i]=0;
            for(int j=0;j<r;j++)
            {
                if((need[i][j]>av[j])||(point[i]==true))
                    break;
                else
                flag[i]++;
            }
            if(flag[i]==r)
            {
                safe="P"+(i+1)+safe;
                for(int k=0;k<r;k++)
                    av[k]=av[k]+alloc[i][k];
                point[i]=true;
            }
        }
        c=0;
        for(int i=0;i<p;i++)
        {
            if(point[i]==true)
                c++;
            else
                break;
        }
        if(c==p)
        {
            System.out.println("Safe state.Safe sequence is:"+safe);
        }
        else
        {
            System.out.println("Unsafe state.Deadlock can occur.");
        }
    }

}