package interview26Dec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
* Deepanshu Agrawal4:01 PM
Course Schedule


There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.
Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.*/
public class CourseSchedule {
    //Input: numCourses = 5, prerequisites = [[1,0],[2,0],[3,1],[3,2],[4,3], [2,4]]
    //0->null
    //1->0
    //2->0,4
    //3->1,2
    //4->3
    public static boolean scheduleCourse(int numCourses, int[][] prerequisites){
        Map<Integer, List<Integer>> courseMap=createCourseMap(prerequisites);
        Set<Integer> currentCourses=new HashSet<>();
        boolean[] finishedCourse=new boolean[numCourses];
        for(int courseNumber=0;courseNumber<numCourses;courseNumber++){
            if(!finishedCourse[courseNumber]){
                if(isPrerequisiteCourseDone(courseNumber,finishedCourse,courseMap,currentCourses)) {
                   continue;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isPrerequisiteCourseDone(int courseNumber, boolean[] finishedCourse,Map<Integer, List<Integer>> courseMap,Set<Integer> currentCourses){
        if(currentCourses.contains(courseNumber)){
            return false;
        }
        List<Integer> preRequisiteCourses=courseMap.get(courseNumber);
        currentCourses.add(courseNumber);
        if(preRequisiteCourses==null || preRequisiteCourses.size()==0){
            return true;
        }
        System.out.println("Course number: "+courseNumber+" Number of prerequisites: "+preRequisiteCourses.size());
        for(int preRequisiteCourse: preRequisiteCourses){
            System.out.println("Prerequisite course: "+preRequisiteCourse+" is done");
            if(!finishedCourse[preRequisiteCourse]){
                if(isPrerequisiteCourseDone(preRequisiteCourse,finishedCourse,courseMap,currentCourses)){
                    return true;
                }
            }
        }
        finishedCourse[courseNumber]=true;
        currentCourses.remove(courseNumber);
        return false;
    }
    public static Map<Integer, List<Integer>> createCourseMap(int[][] prerequisites){
        Map<Integer, List<Integer>> courseMap=new HashMap<>();
        for(int i=0;i< prerequisites.length;i++){
            int courseNumber=prerequisites[i][0];
            int preRequisiteCourse=prerequisites[i][1];
            List<Integer> preRequisiteCourses=new ArrayList<>();
            if(courseMap.containsKey(courseNumber)){
                preRequisiteCourses= courseMap.get(courseNumber);
            }
            preRequisiteCourses.add(preRequisiteCourse);
            courseMap.put(courseNumber,preRequisiteCourses);
        }
        return courseMap;
    }
    public static void main(String[] args) {
        int [][]prerequisites={{1,0},{2,0},{3,1},{3,2},{4,3}};
        int numCourses=2;
        boolean isCourseScheduled=scheduleCourse(numCourses,prerequisites);
        System.out.println("Can we schedule? "+isCourseScheduled);
    }

}
//1->3,5
//2->3

//0(key)->1(prerequisite course)->list
//1->null

//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//1->0
//2->0
//3->1,2

//3->1,2->0


