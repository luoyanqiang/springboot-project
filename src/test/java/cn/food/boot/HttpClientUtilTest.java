package cn.food.boot;

import cn.food.boot.utils.http.HttpClientUtil;
import cn.food.boot.utils.http.exception.MethodNotSupportException;
import cn.food.boot.utils.http.request.RequestMethod;
import cn.food.boot.utils.http.request.UrlEncodedFormRequest;
import cn.food.boot.utils.http.response.Response;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class HttpClientUtilTest {

    @Test
    public void doResponse() throws MethodNotSupportException {
        UrlEncodedFormRequest request = new UrlEncodedFormRequest("http://localhost:8080/testPost", RequestMethod.POST);

        request.addParam("height", "180");
        request.addParam("weight", "150");

        request.addParam("version", "v1");

        Response response = HttpClientUtil.doRequest(request);
        System.out.println(response.getResponseText());
        System.out.println(response.getCode());

    }

    @Test
    public void testArray() throws IOException {
        FileReader fileReader = new FileReader("test.txt");
        char[] chars = new char[1024];
        int count = 0;
        String word = "hello";
        while(fileReader.read(chars) != -1) {
            int startIndex = 0;
            int findIndex = 0;
            String line = new String(chars);
            System.out.println(line);
            while((findIndex = line.indexOf(word, startIndex)) != -1) {
                count += 1;
                startIndex = findIndex + word.length();
            };
        };
        System.out.println(count);
        fileReader.close();
    }

    @Test
    public void testBufferedReader() throws IOException {
        Reader reader = new FileReader("test.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        String word = "hello";
        int count = 0;
        while((line = bufferedReader.readLine()) != null) {
            int startIndex = 0;
            int findIndex = 0;
            while((findIndex = line.indexOf(word, startIndex)) != -1) {
                startIndex = findIndex + word.length();
                count += 1;
            }
        }
        System.out.println(count);
        bufferedReader.close();
        reader.close();
    }

    @Test
    public void testSortArray() {
        int[] arr = {10, 5, 6, 8};
        this.sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testInt() {
        StringBuilder a = new StringBuilder("hello");
        this.addInt(a);
        System.out.println(a);
    }

    public void addInt(StringBuilder a) {
        a.append(" world");
        System.out.println(a);
    }

    public int[] sortArray(int[] arr) {
        int length = arr.length;
        for(int i =0; i < length; i++) {
            for(int j = 0; j < length - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        return arr;
    }

    @Test
    public void testQuick() {
        int[] arr = {10, 7, 8, 6, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

   public int getMiddle(int[] arrs, int low, int high) {
        int temp = arrs[low];
        while(low < high) {
            while(low < high && arrs[high] > temp) {
                high--;
            }
            arrs[low] = arrs[high]; //比中轴小的移到左边
            while(low < high && arrs[low] < temp) {
                low++;
            }
            arrs[high] = arrs[low]; //比中轴大的移到右边
        }
        arrs[low] = temp;
        return low;
   }

   public void quickSort(int[] arrs, int low, int high) {
       if(low < high) {
           int middle = getMiddle(arrs, low, high);
           quickSort(arrs, low, middle - 1);
           quickSort(arrs, middle + 1, high);
       }
   }

   public void selSort(int[] arrs) {
       int size = arrs.length;
       int temp = 0;
       for(int i = 0; i < size; i++) {
           int index = i;
           for(int j = size -1; j > i; j--) {
               System.out.println(index + "====" + i);
                if(arrs[j] < arrs[index]) {
                    index = j;
                }
           }

           temp = arrs[i];
           arrs[i] = arrs[index];
           arrs[index] = temp;
       }
   }

   @Test
   public void testSelSort() {
        int[] arr = {10, 6, 7, 3};
        this.selSort(arr);
        System.out.println(Arrays.toString(arr));
   }




}
