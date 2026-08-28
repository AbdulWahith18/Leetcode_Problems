            }
        }
        if(oddCount==1)
        {
            leftHalf.append(oddChar);
            leftHalf.append(leftHalf.reverse());
        }
        else
            leftHalf.append(leftHalf.reverse());

        String rev=leftHalf.toString();
        int com=rev.compareTo(target);
        if(com>0)
            return rev;
        return "";
            
    }
