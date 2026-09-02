import java.util.*;

public class PGM64063 {

    private static final Map<Long, Long> roomMap = new HashMap<>(); // key: 요청된 방 번호, value: 다음으로 확인해야 할 방 번호

    public long[] solution(long k, long[] room_number) {
        roomMap.clear();

        long[] assignedRoom = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            assignedRoom[i] = findAssignableRoom(room_number[i]);
        }

        return assignedRoom;
    }

    private static long findAssignableRoom(long roomNumber) {
        // 확인하는 방이 비어있는 방이면 배정 후 HashMap에 value를 다음 빈 방 후보를 가리키도록 저장
        if (!roomMap.containsKey(roomNumber)) {
            roomMap.put(roomNumber, roomNumber + 1);

            return roomNumber;
        }

        // 방이 차 있다면 빈 방을 찾을 때까지 재귀 탐색 (Union-Find의 Find)
        // 거쳐간 방들의 value를 이번에 찾은 빈 방 번호로 갱신하여 경로 압축 (Path Compression)
        long nextRoomNumber = findAssignableRoom(roomMap.get(roomNumber));
        roomMap.put(roomNumber, nextRoomNumber);

        return nextRoomNumber;
    }
}
