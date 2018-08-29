### 命令模式
- 描述
> 将请求封装成一个对象，命令的请求和命令的执行在不同的对象中执行。
- 涉及到的角色
    - 客户端
    - 请求发送者角色
    - 抽象命令角色
    - 具体命令角色
    - 请求接收者角色
> 客户端操作，触发请求者发送命令，然后接收者执行命令
- 场景
> 音频播放器具有播放、倒带、停止功能，Julia（客户端）可以点击这些按钮（请求发送者）来发送命令给播放器，播放器（请求接收者）处理这些请求响应用户
- 实例
    - 请求发送者
    ```
    public class Keypad {

        private Command playCommand;
    
        private Command rewindCommand;
    
        private Command stopCommand;
    
        public void setPlayCommand(Command playCommand) {
            this.playCommand = playCommand;
        }
    
        public void setRewindCommand(Command rewindCommand) {
            this.rewindCommand = rewindCommand;
        }
    
        public void setStopCommand(Command stopCommand) {
            this.stopCommand = stopCommand;
        }
    
        public void play() {
            this.playCommand.execute();
        }
    
        public void rewind() {
            this.rewindCommand.execute();
        }
    
        public void stop() {
            this.stopCommand.execute();
        }
    }
    ```
    - 抽象命令以及具体命令
    ```
    public interface Command {
    
        void execute();
    }

    public class PlayCommand implements Command {
    
        private AudioPlayer audioPlayer;
    
        public PlayCommand(AudioPlayer audioPlayer) {
            this.audioPlayer = audioPlayer;
        }
    
        @Override
        public void execute() {
            this.audioPlayer.play();
        }
    }
    
    public class RewindCommand implements Command {

        private AudioPlayer audioPlayer;
    
        public RewindCommand(AudioPlayer audioPlayer) {
            this.audioPlayer = audioPlayer;
        }
    
        @Override
        public void execute() {
            this.audioPlayer.rewind();
        }
    }
    
    public class StopCommand implements Command {

        private AudioPlayer audioPlayer;
    
        public StopCommand(AudioPlayer audioPlayer) {
            this.audioPlayer = audioPlayer;
        }
    
        @Override
        public void execute() {
            this.audioPlayer.stop();
        }
    }
    ```
    - 请求接收者
    ```
    public class AudioPlayer {

        public void play() {
            System.out.println("播放");
        }
    
        public void rewind() {
            System.out.println("倒带");
        }
    
        public void stop() {
            System.out.println("停止");
        }
    }
    ```
    - 客户端
    ```
    public class Julia {

        public static void main(String[] args) {
            AudioPlayer audioPlayer = new AudioPlayer();
    
            Command playCommand = new PlayCommand(audioPlayer);
            Command rewindCommand = new RewindCommand(audioPlayer);
            Command stopCommand = new StopCommand(audioPlayer);
    
            Keypad keypad = new Keypad();
            keypad.setPlayCommand(playCommand);
            keypad.setRewindCommand(rewindCommand);
            keypad.setStopCommand(stopCommand);
    
            keypad.play();
            keypad.rewind();
            keypad.stop();
        }
    }
    ```
- [《JAVA与模式》之命令模式
](http://www.cnblogs.com/java-my-life/archive/2012/06/01/2526972.html)