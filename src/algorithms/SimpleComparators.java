package algorithms;

import commons.Job;

import java.util.Comparator;

public class SimpleComparators {


    public static final class RDPComparator implements Comparator<Job> {
        @Override
        public int compare(Job j1, Job j2) {
            int result = j1.getReadyTime() - j2.getReadyTime();
            if (result == 0) {
                result = j1.getDueTime() - j2.getDueTime();
                if (result == 0) {
                    result = j1.getProcessingTime() - j2.getProcessingTime();
                }
            }
            return result;
        }
    }

    public static final class RPDComparator implements Comparator<Job> {
        @Override
        public int compare(Job j1, Job j2) {
            int result = j1.getReadyTime() - j2.getReadyTime();
            if (result == 0) {
                result = j1.getProcessingTime() - j2.getProcessingTime();
                if (result == 0) {
                    result = j1.getDueTime() - j2.getDueTime();
                }
            }
            return result;
        }
    }

    public static final class PRDComparator implements Comparator<Job> {
        @Override
        public int compare(Job j1, Job j2) {
            int result = j1.getProcessingTime() - j2.getProcessingTime();
            if (result == 0) {
                result = j1.getReadyTime() - j2.getReadyTime();
                if (result == 0) {
                    result = j1.getDueTime() - j2.getDueTime();
                }
            }
            return result;
        }
    }

    public static final class PDRComparator implements Comparator<Job> {
        @Override
        public int compare(Job j1, Job j2) {
            int result = j1.getProcessingTime() - j2.getProcessingTime();
            if (result == 0) {
                result = j1.getDueTime() - j2.getDueTime();
                if (result == 0) {
                    result = j1.getReadyTime() - j2.getReadyTime();
                }
            }
            return result;
        }
    }


    public static final class DPRComparator implements Comparator<Job> {
        @Override
        public int compare(Job j1, Job j2) {
            int result = j1.getDueTime() - j2.getDueTime();
            if (result == 0) {
                result = j1.getProcessingTime() - j2.getProcessingTime();
                if (result == 0) {
                    result = j1.getReadyTime() - j2.getReadyTime();
                }
            }
            return result;
        }
    }

    public static final class DRPComparator implements Comparator<Job> {
        @Override
        public int compare(Job j1, Job j2) {
            int result = j1.getDueTime() - j2.getDueTime();
            if (result == 0) {
                result = j1.getReadyTime() - j2.getReadyTime();
                if (result == 0) {
                    result = j1.getProcessingTime() - j2.getProcessingTime();
                }
            }
            return result;
        }
    }
}
