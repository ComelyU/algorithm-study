import java.util.*;

public class PGM42579 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genrePlayHashMap = new HashMap<>(); // 장르별 재생 횟수
        HashMap<String, PriorityQueue<Music>> genreMusicHashMap = new HashMap<>(); // 장르별 재생 회수 상위 2곡

        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 장르별 총 재생 횟수 누적
            genrePlayHashMap.put(genres[i], genrePlayHashMap.getOrDefault(genre, 0) + play);

            // 장르별 재생 횟수 상위 2곡 유지
            genreMusicHashMap.putIfAbsent(genre, new PriorityQueue<>());
            PriorityQueue<Music> musicQueue = genreMusicHashMap.get(genre);

            musicQueue.offer(new Music(i, genre, play)); // Inner Class인 Music의 compareTo에 따라 정렬됨

            if(musicQueue.size() > 2) {
                musicQueue.poll();
            }
        }

        // 총 재생 횟수를 기준으로 장르 정렬
        ArrayList<String> sortedGenres = new ArrayList<>(genrePlayHashMap.keySet());
        sortedGenres.sort((a, b) -> genrePlayHashMap.get(b) - genrePlayHashMap.get(a));

        // 베스트앨범 제작
        ArrayList<Integer> album = new ArrayList<>();
        for(String genre : sortedGenres) {
            PriorityQueue<Music> musicQueue = genreMusicHashMap.get(genre);

            if(musicQueue.size() == 2) {
                Music secondMusic = musicQueue.poll(); // 해당 장르 2위곡
                Music firstMusic = musicQueue.poll(); // 해당 장르 1위곡

                album.add(firstMusic.id);
                album.add(secondMusic.id);
            } else if(musicQueue.size() == 1) {
                album.add(musicQueue.poll().id);
            }
        }

//        return album.stream().mapToInt(Integer::intValue).toArray();

        int[] albumResult = new int[album.size()];
        for(int i = 0; i < album.size(); i++) {
            albumResult[i] = album.get(i);
        }

        return albumResult;
    }

    static class Music implements Comparable<Music> {
        int id; // 고유 번호
        String genre; // 장르
        int play; // 재생 횟수

        public Music(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(Music o) {
            // 문제에서 동일 단계 앨범 수록 우선 순위 반대로 PriorityQueue에서 우선 순위 설정.
            // 재생 횟수 적으면 PriorityQueue에서 먼저 제거되어야 함. 즉, 우선 순위 높음.
            if(this.play == o.play) {
                // 재생 횟수 같으면 고유 번호가 큰 것이 먼저 제거되어야 함.
//                return Integer.compare(o.id, this.id);
                return o.id - this.id;
            }
//            return Integer.compare(this.play, o.play);
            return this.play - o.play;
        }
    }
}
