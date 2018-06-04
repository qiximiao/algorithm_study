public class Lcs最长公共子串 {

    public static void lcs_length(String str1,String str2){
        char[] arr1=str1.toCharArray();
        char[] arr2=str2.toCharArray();
        //TODO 防止异常

        int[][] opt=new int[arr1.length+1][arr2.length+1];
        for(int i=arr1.length-1;i>=0;i--){
            for(int j=arr2.length-1;j>=0;j--){
                if(arr1[i]==arr2[j]){
                    opt[i][j]=opt[i+1][j+1]+1;
                }
                else{
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
                }
            }
        }

        
    }
}
