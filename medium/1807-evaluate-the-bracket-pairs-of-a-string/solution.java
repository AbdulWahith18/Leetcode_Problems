class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> m=new HashMap<>();
        StringBuilder result=new StringBuilder();
        for(List<String> str:knowledge)
        {
            m.put(str.get(0),str.get(1));
        }
        char[] c=s.toCharArray();
        boolean flag=false;
        StringBuilder st=new StringBuilder();
        for(int i=0;i<c.length;i++)
        {
            if(c[i]=='(')
            {
                flag=true;
            }
            else if(Character.isLetter(c[i]))
            {
                if(flag)
                    st.append(c[i]);
                else
                    result.append(c[i]);
            }
            else
            {
                flag=false;
                String com=st.toString();
                if (m.containsKey(com))
                    result.append(m.get(com));
                else
                    result.append("?");
                st.setLength(0);
            }
        }
        return result.toString();
    }
}