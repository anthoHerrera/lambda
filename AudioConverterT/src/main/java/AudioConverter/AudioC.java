package AudioConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.MultimediaObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;


public class AudioC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File source = new File("C:/Users/USER/Desktop/ap.mp3");
		byte[] bytes;
		JSONParser jsonParser = new JSONParser();
		try {
			
			FileReader reader = new FileReader("C:/Users/USER/Desktop/audio.json");
			Object obj = jsonParser.parse(reader);
			 
            JSONArray audioList = (JSONArray) obj;
            
            audioList.forEach( emp -> {
				try {
					parseAudioObject( (JSONObject) emp );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} );
            
			/*bytes = FileUtils.readFileToByteArray(source);
			Base64.Encoder encoder1 = Base64.getEncoder();  
			String encoded = encoder1.encodeToString(bytes);
			JSONObject jsonAudio = new JSONObject();
			jsonAudio.put("file", encoded);
			JSONArray paramList = new JSONArray();
	        paramList.add(jsonAudio);
			try (FileWriter file = new FileWriter("C:/Users/USER/Desktop/audio.json")) {
				 
	            file.write(paramList.toJSONString());
	            file.flush();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }*/
			//System.out.println(encoded);
			/*Base64.Decoder decoder = Base64.getDecoder();  
			byte[] bytes2 = decoder.decode(encoded);
			File source1 = new File("C:/Users/USER/Desktop/encode.mp3");
			File target1 = new File("C:/Users/USER/Desktop/out.ac3");
			OutputStream os = new FileOutputStream(source1);
            os.write(bytes2);
            System.out.println("Write bytes to file.");
            os.close();
            
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
			try {
				encoder.encode(new MultimediaObject(source1), target1, attrs);
			} catch (IllegalArgumentException | EncoderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
            
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		/*try {
			File source = new File("C:/Users/USER/Desktop/ap.mp3");
			File target = new File("C:/Users/USER/Desktop/ap.mp3");

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
			
		}*/
		
		/*try {
			File source1 = new File("C:/Users/USER/Desktop/ap.ogg");
			File target1 = new File("C:/Users/USER/Desktop/ap.ac3");

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
			File source2 = new File("C:/Users/USER/Desktop/ap.mp3");
			File target2 = new File("C:/Users/USER/Desktop/ap.ogg");

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
			
		}*/

		
	}
	private static void parseAudioObject(JSONObject audio) throws IOException 
    {
        
         
        //Get employee first name
        String firstName = (String) audio.get("file");    
        
        Base64.Decoder decoder = Base64.getDecoder();  
		byte[] bytes2 = decoder.decode(firstName);
		File source1 = new File("C:/Users/USER/Desktop/encode.mp3");
		File target1 = new File("C:/Users/USER/Desktop/out.ac3");
		OutputStream os = new FileOutputStream(source1);
        os.write(bytes2);
        System.out.println("Write bytes to file.");
        os.close();
        
        AudioAttributes audiot = new AudioAttributes();
		audiot.setCodec("ac3");
		audiot.setBitRate(128000);
		audiot.setChannels(2);
		audiot.setSamplingRate(44100);

		// Encoding attributes
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("ac3");
		attrs.setAudioAttributes(audiot);

		// Encode
		Encoder encoder = new Encoder();
		try {
			encoder.encode(new MultimediaObject(source1), target1, attrs);
		} catch (IllegalArgumentException | EncoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        
        
    }

}
