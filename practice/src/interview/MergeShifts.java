package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Shift{
    int startTime;
    int endTime;

    public Shift(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    @Override
    public String toString(){
        return "["+startTime+","+endTime+"]";
    }
}
public class MergeShifts {

    public static List<Shift> mergeShits(ArrayList<Shift> shiftList){
        List<Shift> mergedShifts=new ArrayList<>();
        if(shiftList.size()==0){
            return mergedShifts;
        }
        if(shiftList.size()==1 && shiftList.get(0).startTime>shiftList.get(0).endTime){
            return shiftList;
        }

        shiftList.sort(Comparator.comparingInt(shift -> shift.startTime));

        Shift previousShift=shiftList.get(0);
        for(int index=1;index<shiftList.size();index++)
        {
            Shift currentShift=shiftList.get(index);
            if(previousShift.endTime>currentShift.endTime){
                continue;
            }
            if(previousShift.endTime>=currentShift.startTime){
                    Shift mergeShift = new Shift(previousShift.startTime, currentShift.endTime);
                    mergedShifts.add(mergeShift);
                    previousShift.endTime = currentShift.endTime;
            }
            else
            {
                mergedShifts.add(currentShift);
                previousShift=currentShift;
            }
        }
        return mergedShifts;
    }
    public static void main(String[] args) {
        ArrayList<Shift> shiftList=new ArrayList<>();
        Shift shift1=new Shift(8,10);
        Shift shift2=new Shift(10,12);
        Shift shift3=new Shift(14,19);
        shiftList.add(shift1);
        shiftList.add(shift2);
        shiftList.add(shift3);
        List<Shift> mergedLists=mergeShits(shiftList);
        System.out.println(mergedLists);
        System.out.println("-----------------");
        shiftList=new ArrayList<>();
        shift1=new Shift(10,12);
        shift2=new Shift(8,12);
        shift3=new Shift(14,19);
        shiftList.add(shift1);
        shiftList.add(shift2);
        shiftList.add(shift3);
        mergedLists=mergeShits(shiftList);
        System.out.println(mergedLists);
        System.out.println("-----------------");
        shiftList=new ArrayList<>();
        shift1=new Shift(10,24);
        shift2=new Shift(8,11);
        shift3=new Shift(14,19);

        //8,11 10,24 14,19
        //
        shiftList.add(shift1);
        shiftList.add(shift2);
        shiftList.add(shift3);
        mergedLists=mergeShits(shiftList);
        System.out.println(mergedLists);
    }

}
