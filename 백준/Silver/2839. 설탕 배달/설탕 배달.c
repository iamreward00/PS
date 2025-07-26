#include<stdio.h>

int main()
{
    int n;
    int tc,fc,ch;
    tc = fc = ch = -1;
    scanf("%d",&n);
    
    for(int a = 0; a <=n ; a+=3)
      { 
        tc++;
        for(int b = 0; b <= n ; b+=5)
        {
            fc++;
           
            if(a + b == n){
                ch = 0;
                a = n;
                printf("%d",tc+fc);
                break;}
        }  
        fc =-1;
    }
    if(ch!=0)
        printf("-1");
    
    
    
    
    
    return 0;
}