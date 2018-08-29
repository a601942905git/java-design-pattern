### 适配器模式
- 描述
> 适配两个不兼容的接口
- 场景
> 普通的音频播放器只能播放mp3格式的文件，但是想让其播放mp4格式和vlc格式的文件
- 实例
    - 普通播放器接口
    ```
    public interface MediaPlayer {

        void play(String type, String fileName);
    }
    ```
    - 普通播放器接口实现类
    ```
    public class AudioMediaPlayer implements MediaPlayer {

        @Override
        public void play(String type, String fileName) {
            if (Objects.equals(type, MediaConstants.MP3)) {
                System.out.println(String.format("正在播放类型为：%s,名称为：%s的音频", type, fileName));
            } else if (Objects.equals(type, MediaConstants.MP4)
                    || Objects.equals(type, MediaConstants.VLC)) {
                MediaAdapter mediaAdapter = new MediaAdapter(type);
                mediaAdapter.play(type, fileName);
            } else {
                System.out.println("not found media");
            }
        }
    }
    ```
    - 高级播放器接口
    ```
    public interface AdvanceMediaPlayer {

        void playVlc(String fileName);
    
        void playMp4(String fileName);
    }
    ```
    - 高级播放器接口实现类
    ```
    public class Mp4Player implements AdvanceMediaPlayer {

        @Override
        public void playVlc(String fileName) {
    
        }
    
        @Override
        public void playMp4(String fileName) {
            System.out.println(String.format("正在播放类型为：Mp4,名称为：%s的音频", fileName));
        }
    }

    public class VlcPlayer implements AdvanceMediaPlayer {
    
        @Override
        public void playVlc(String fileName) {
            System.out.println(String.format("正在播放类型为：Vlc,名称为：%s的音频", fileName));
        }
    
        @Override
        public void playMp4(String fileName) {
    
        }
    }
    ```
    - 适配器
    ```
    public class MediaAdapter implements MediaPlayer {

        private AdvanceMediaPlayer advanceMediaPlayer;
    
        public MediaAdapter(String type) {
            if (Objects.equals(type, MediaConstants.MP4)) {
                advanceMediaPlayer = new Mp4Player();
            } else if (Objects.equals(type, MediaConstants.VLC)) {
                advanceMediaPlayer = new VlcPlayer();
            }
        }
    
        @Override
        public void play(String type, String fileName) {
            if (Objects.equals(type, MediaConstants.MP4)) {
                advanceMediaPlayer.playMp4(fileName);
            } else if (Objects.equals(type, MediaConstants.VLC)) {
                advanceMediaPlayer.playVlc(fileName);
            }
        }
    }
    ```
    - 测试
    ```
    public class Test {

        public static void main(String[] args) {
            MediaPlayer media = new AudioMediaPlayer();
            media.play("mp3", "beyond the horizon.mp3");
            media.play("mp4", "alone.mp4");
            media.play("vlc", "far far away.vlc");
            media.play("avi", "mind me.avi");
        }
    }
    ```