class Marathon {
    public static int first_place(int[] arr){
        int count = arr[0];
        int first = 0;
        for(int i = 1; i< arr.length; i++){
            if(arr[i]<count){
                count = arr[i];
                first = i;
            }
        }
        return first;
    }
    public static int second_place(int[] arr){
        int first_index = first_place(arr);
        int count = arr[0];
        int second = 0;
        for(int i = 1; i< arr.length; i++){
            if (i== first_index){
                continue;
            }else if (arr[i]< count) {
                count = arr[i];
                second = i;
            }
        }
        return second;
    }
    public static void main (String[] arguments) {
        String[] names = {
            "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
            "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
            "Aaron", "Kate"
        };

        int[] times = {
            341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
            343, 317, 265
        };

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + times[i]);
        }

        int first_index = first_place(times);
        System.out.println(names[first_index]);
        int second_index = second_place(times);
        System.out.println(names[second_index]);
    }
} 