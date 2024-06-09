// the sume of three contigous items of an array should equal to target value.

public class A00 {
    public static void main(String[] args) {
        //                    0,1,2,3,4,5,6,7,8,9,10
        int[] arr = new int[]{1,2,2,9,4,5,6,2,8,0,10};

        int target = 18;

        int pointer1 = 0;
        int pointer2 = 2;
        boolean targetFound = false;

        for(int i = 0 ; i < arr.length ; i++){
            if(pointer2 != arr.length-1){
                if(sum(pointer1,pointer2,arr) == target){
                    targetFound = true;
                    break;
                }

                pointer1++;
                pointer2++;
            }
        }
        if(targetFound){

        System.out.println("The upper and lower bounds of array index's which add up to "+target+" are : "+pointer1+" , "+pointer2);
        }else{
            System.out.println("target not found");
        }
    }


    public static int sum(int pointer1 , int pointer2 , int arr[]){
        int sum = 0 ;
        for(int i = pointer1 ; i <= pointer2 ; i++){
            sum+=arr[i];
        }
        return sum;
    }
}
