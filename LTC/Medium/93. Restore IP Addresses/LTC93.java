import java.util.*;

public class LTC93 {

    private static final int MIN_IP_LENGTH = 4;
    private static final int MAX_IP_LENGTH = 12;
    private static final int MAX_SEGMENT_LENGTH = 3;
    private static final int REQUIRED_SEGMENTS = 4;
    private static final int MAX_SEGMENT_VALUE = 255;

    public List<String> restoreIpAddresses(String s) {
        List<String> validIpAddresses = new ArrayList<>();

        if (s == null || s.length() < MIN_IP_LENGTH || s.length() > MAX_IP_LENGTH) {
            return validIpAddresses;
        }

        extractValidIpAddresses(s, 0, new ArrayList<>(), validIpAddresses);

        return validIpAddresses;
    }

    // DFS with Backtracking
    // Uses a List to track current segments for better code readability.
    // Note: A StringBuilder can also be used as an alternative to minimize memory allocation.
    private void extractValidIpAddresses(String source, int currentIdx, List<String> currentSegments, List<String> validIpAddresses) {
        if (currentSegments.size() == REQUIRED_SEGMENTS) {
            if (currentIdx == source.length()) {
                validIpAddresses.add(String.join(".", currentSegments));
            }

            return;
        }

        for (int length = 1; length <= MAX_SEGMENT_LENGTH; length++) {
            if (currentIdx + length > source.length()) {
                break;
            }

            String segment = source.substring(currentIdx, currentIdx + length);
            if (!isValidSegment(segment)) {
                continue;
            }

            currentSegments.add(segment);
            extractValidIpAddresses(source, currentIdx + length, currentSegments, validIpAddresses);
            currentSegments.remove(currentSegments.size() - 1);
        }
    }

    private boolean isValidSegment(String segment) {
        if (segment.startsWith("0") && segment.length() > 1) {
            return false;
        }

        return Integer.parseInt(segment) <= MAX_SEGMENT_VALUE;
    }

}
