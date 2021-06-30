package hit.Lab_project;

public class UniversalRemoteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv tv = new Tv();
		SetTopBox setTopBox = new SetTopBox();
		Netflix netflix = new Netflix();
		SoundSystem soundSystem = new SoundSystem();
//		Command cc = new FatherChannel(tv, setTopBox, soundSystem, netflix);
//		cc.execute();
		FatherChannel fc = new FatherChannel(tv, setTopBox, soundSystem, netflix);
		MotherMovies mm = new MotherMovies(tv, setTopBox, soundSystem, netflix);
		MotherSerial ms = new MotherSerial(tv, setTopBox, soundSystem, netflix);
		
		Remote remote = new Remote();
		remote.setCommand(fc, 0);
		remote.setCommand(mm, 1);
		remote.setCommand(ms, 2);
		
		remote.executeCommand(1);
	}

}
class Tv{
	public void av1() {
		System.out.println("tv switched to av1 mode...");
	}
	public void switchOn() {
		System.out.println("TV is switched on.......");
	}
	
}
class SetTopBox{
	public void newsChannel() {
		System.out.println("news channel started.....");
	}
	public void serialChannel() {
		System.out.println("serial channel started.....");

	}
}
class Netflix{
	public void oldMovies() {
		System.out.println("old movie started....");

	}
}
class SoundSystem{
	public void lowSound() {
		System.out.println("sound volume....decreased....");

	}
}
interface Command{
	void execute();
}
class FatherChannel implements Command{
	Tv tv;SetTopBox setTopBox;Netflix netflix;SoundSystem soundSystem;
	public FatherChannel(Tv tv, SetTopBox setTopBox, SoundSystem soundSystem, Netflix netflix) {
		this.tv = tv;
		this.setTopBox = setTopBox;
		this.soundSystem = soundSystem;
		this.netflix = netflix;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Father Channel is Stated");
		tv.av1();
		tv.switchOn();
		setTopBox.newsChannel();
		soundSystem.lowSound();
		System.out.println("Dad Enjoy .started news Channel.........");
		
	}
}
class MotherSerial implements Command{
	Tv tv;SetTopBox setTopBox;Netflix netflix;SoundSystem soundSystem;
	public MotherSerial(Tv tv, SetTopBox setTopBox, SoundSystem soundSystem, Netflix netflix) {
		this.tv = tv;
		this.setTopBox = setTopBox;
		this.soundSystem = soundSystem;
		this.netflix = netflix;
	}
	@Override
	public void execute() {
		System.out.println("Mother Serial Channel is Started.....");		
		tv.av1();
		tv.switchOn();
		setTopBox.serialChannel();
		soundSystem.lowSound();
		System.out.println("Mother Enjoy .Started Serial Channel.......");
	}
	
}
class MotherMovies implements Command{
	Tv tv;SetTopBox setTopBox;Netflix netflix;SoundSystem soundSystem;
	public MotherMovies(Tv tv, SetTopBox setTopBox, SoundSystem soundSystem, Netflix netflix) {
		this.tv = tv;
		this.setTopBox = setTopBox;
		this.soundSystem = soundSystem;
		this.netflix = netflix;
	}
	@Override
	public void execute() {
		System.out.println("Mother Movies Channel is Started.....");		
		tv.av1();
		tv.switchOn();
		netflix.oldMovies();;
		soundSystem.lowSound();
		System.out.println("Mother Enjoy .Started Movies Channel.......");
	}
	
}
class DummyCommand implements Command{
	@Override
	public void execute() {
		System.out.println("I am a dummy button...");
	}
}
class Remote{
	Command command[]=new Command[5];
	public Remote() {
		for(int i=0;i<command.length;i++) {
			command[i]=new DummyCommand();
		}

	}
	public void setCommand(Command command,int slot) {
		this.command[slot]=command;
	}
	public void executeCommand(int slot) {
		command[slot].execute();
	}
}
