class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        
        HashMap<ArrayList<Integer>,Integer> hm=new HashMap<ArrayList<Integer>,Integer>();
        HashMap<String,Integer> hm1=new HashMap<String,Integer>();
        int Xmin=Integer.MAX_VALUE, Ymin=Integer.MAX_VALUE;
        int Xmax=Integer.MIN_VALUE, Ymax=Integer.MIN_VALUE;
        int X1,Y1,X2,Y2;
        //int[][] checkOverlap= new [rectangles.length][4];
        int totalArea=0;
        for(int[] singleRect : rectangles){
            
            X1=singleRect[0];
            Y1=singleRect[1];
            X2=singleRect[2];
            Y2=singleRect[3];
            if(hm1.containsKey(Arrays.toString(singleRect))) return false;
            hm1.put(Arrays.toString(singleRect),hm1.getOrDefault(Arrays.toString(singleRect),0)+1);
            Xmin=Math.min(Xmin, Math.min(X1,X2));
            Ymin=Math.min(Ymin, Math.min(Y1,Y2));
            Xmax=Math.max(Xmax, Math.max(X1,X2));
            Ymax=Math.max(Ymax, Math.max(Y1,Y2));
            
            ArrayList<Integer> key1=new ArrayList<>(Arrays.asList(X1, Y1));
            ArrayList<Integer> key2=new ArrayList<>(Arrays.asList(X2, Y2));
            ArrayList<Integer> key3=new ArrayList<>(Arrays.asList(X1, Y2));
            ArrayList<Integer> key4=new ArrayList<>(Arrays.asList(X2, Y1));
            hm.put(key1,hm.getOrDefault(key1,0)+1);
            hm.put(key2,hm.getOrDefault(key2,0)+1);
            hm.put(key3,hm.getOrDefault(key3,0)+1);
            hm.put(key4,hm.getOrDefault(key4,0)+1);
            System.out.println("ookk:"+Xmin+":"+Ymin+":"+Xmax+":"+Ymax);
            totalArea+=(X2-X1)*(Y2-Y1);
        }
        
        int area=(Xmax-Xmin)*(Ymax-Ymin);
        if(area!=totalArea) return false;
        System.out.println("ookk:"+hm);
        
        for(HashMap.Entry<ArrayList<Integer>,Integer> entry : hm.entrySet()){
            if(entry.getValue()%2==1){//odd count
                System.out.println("ookk_first");
                int X=entry.getKey().get(0);
                int Y=entry.getKey().get(1);
                if(!((X==Xmax||X==Xmin) && (Y==Ymax||Y==Ymin))){//check for non corners
                    System.out.println("ookk");
                    return false;
                }
            }
            else if(entry.getValue()%2==0){//even count
                System.out.println("ookk_second");
                int X=entry.getKey().get(0);
                int Y=entry.getKey().get(1);
                if((X==Xmax||X==Xmin) && (Y==Ymax||Y==Ymin)){//check for corners
                    System.out.println("ookk555555555555555555555");
                    return false;
                }
            }
        }
        
        
        
        return true;
    }
}