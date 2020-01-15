package AudioConverter;

import java.io.File;

import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.MultimediaObject;

public class AudioC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File source = new File("C:/Users/USER/Desktop/abc.ogg");
			File target = new File("C:/Users/USER/Desktop/abcd.mp3");

			// Audio Attributes
			AudioAttributes audio = new AudioAttributes();
			audio.setCodec("libmp3lame");
			audio.setBitRate(128000);
			audio.setChannels(2);
			audio.setSamplingRate(44100);

			// Encoding attributes
			EncodingAttributes attrs = new EncodingAttributes();
			attrs.setFormat("mp3");
			attrs.setAudioAttributes(audio);

			// Encode
			Encoder encoder = new Encoder();
			encoder.encode(new MultimediaObject(source), target, attrs);

		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		
		try {
			File source1 = new File("C:/Users/USER/Desktop/abc.ogg");
			File target1 = new File("C:/Users/USER/Desktop/abcd.ac3");

			// Audio Attributes
			AudioAttributes audio = new AudioAttributes();
			audio.setCodec("ac3");
			audio.setBitRate(128000);
			audio.setChannels(2);
			audio.setSamplingRate(44100);

			// Encoding attributes
			EncodingAttributes attrs = new EncodingAttributes();
			attrs.setFormat("ac3");
			attrs.setAudioAttributes(audio);

			// Encode
			Encoder encoder = new Encoder();
			encoder.encode(new MultimediaObject(source1), target1, attrs);

		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		try {
			File source2 = new File("C:/Users/USER/Desktop/abc.mp3");
			File target2 = new File("C:/Users/USER/Desktop/abcd.ogg");

			// Audio Attributes
			AudioAttributes audio = new AudioAttributes();
			audio.setCodec("libvorbis");
			audio.setBitRate(128000);
			audio.setChannels(2);
			audio.setSamplingRate(44100);

			// Encoding attributes
			EncodingAttributes attrs = new EncodingAttributes();
			attrs.setFormat("ogg");
			attrs.setAudioAttributes(audio);

			// Encode
			Encoder encoder = new Encoder();
			encoder.encode(new MultimediaObject(source2), target2, attrs);

		} catch (Exception ex) {
			ex.printStackTrace();
			
		}

		
	}

}
