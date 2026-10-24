class Solution {

    public String encode(List<String> strs) {

        StringBuilder encoded = new StringBuilder();

        for(String str: strs){

            encoded.append(str.length())
                    .append("#")
                    .append(str);
        }

        return encoded.toString();

    }

    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();

        int i=0;

        while(i<str.length()){

            int del = str.indexOf("#", i);

            int length = Integer.parseInt(str.substring(i, del));
            i= del+1;

            res.add(str.substring(i, i+length));
            i=i+length;
        }

        return res;
    }
}
