package robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import string_operations.StrOps;
import tools.Basics;

public class Robot_controller {
	public static void type(String words){
		try {
			words = translate(words);
			Robot rc = new Robot();
			boolean ctrl = false, shift = false, alt = false;

		
			for(int ii = 0; ii < words.length(); ii++){
				char cc = words.charAt(ii);
				if(cc == '/'){
					String command_string = "";
					String delay = "";
					long delay_i = 0;
					ii++;
					while(ii < words.length() && words.charAt(ii) != '/')
						command_string += words.charAt(ii++);
					if(ii == words.length() - 1 && words.charAt(ii) != '/'){
						System.out.println("Error! invalid input string");
						System.exit(-1);
					}
					if(command_string.length() >= 1){
						int index = StrOps.findPattern(command_string, ":");
						if(index != -1){
							index++;
							while(index < command_string.length())
								delay += command_string.charAt(index++);
							if(delay.equals("")){
								System.out.println("Error Invalid delay sequence");
								System.exit(-1);
							}
							delay_i = Long.parseLong(delay);
							command_string = StrOps.getDilineatedSubstring(command_string, ":", 0, false);
						}
					}
					
					if(command_string.equals("ctrl"))
						ctrl = true;
					else if(command_string.equals("shift"))
						shift = true;
					else if(command_string.equals("alt"))
						alt = true;
					else if(command_string.equals("backspace")){
						pressKey(KeyEvent.VK_BACK_SPACE, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("end")){
						pressKey(KeyEvent.VK_END, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("esc")){
						pressKey(KeyEvent.VK_ESCAPE, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("esc")){
						pressKey(KeyEvent.VK_ESCAPE, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("delete")){
						pressKey(KeyEvent.VK_DELETE, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("home")){
						pressKey(KeyEvent.VK_HOME, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("pgup")){
						pressKey(KeyEvent.VK_PAGE_UP, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("pgdn")){
						pressKey(KeyEvent.VK_PAGE_DOWN, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("tab")){
						pressKey(KeyEvent.VK_TAB, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("capslock")){
						pressKey(KeyEvent.VK_CAPS_LOCK, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}					
					else if(command_string.equals("enter")){
						pressKey(KeyEvent.VK_ENTER, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("")){
						pressKey(KeyEvent.VK_SLASH, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("up")){
						pressKey(KeyEvent.VK_UP, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("down")){
						pressKey(KeyEvent.VK_DOWN, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("right")){
						pressKey(KeyEvent.VK_RIGHT, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.equals("left")){
						pressKey(KeyEvent.VK_LEFT, delay_i, rc, ctrl, alt, shift);
						ctrl = false;
						alt = false;
						shift = false;
					}
					else if(command_string.length()>0 && command_string.charAt(0)=='f'){
						String fn = "";
						int index = 1;
						while(index < command_string.length())
							fn+=command_string.charAt(index++);
						if(!fn.equals(""))
							pressFnKey(Integer.parseInt(fn), delay_i, rc, ctrl, alt, shift);
						else{
							System.out.println("Invalid function key");
							System.exit(-1);
						}
						alt = false;
						shift = false;
						ctrl = false;
					}
					else if(command_string.length()>0 && command_string.charAt(0)=='#'){
						String key = "";
						int index = 1;
						while(index < command_string.length())
							key+=command_string.charAt(index++);
						if(!key.equals(""))
							pressKey(getKey(key.charAt(0)), delay_i, rc, ctrl, alt, shift);
						else{
							System.out.println("Invalid key");
							System.exit(-1);
						}
						alt = false;
						shift = false;
						ctrl = false;
					}
					else if(command_string.length()>0 && command_string.charAt(0)=='d'){
						String delay_val = "";
						int index = 1;
						while(index < command_string.length())
							delay_val += command_string.charAt(index++);
						if(!delay_val.equals(""))
							Basics.delay(Long.parseLong(delay_val));
						else{
							System.out.println("Invalid delay sequence");
							System.exit(-1);
						}
					}
					else{
						System.out.println("Error! invalid type command");
						System.exit(-1);
					}		
				}
				else{
					pressKey(getKey(cc), 0, rc, ctrl, alt, shift);
					ctrl = false;
					alt = false;
					shift = false;
				}
			}
		} catch (AWTException e) {
			System.out.println("Error! error with robot");
		}
	}
	
	private static int getKey(char cc){
		switch(cc){
		case ' ':
			return KeyEvent.VK_SPACE;
		
		case '`':
			return KeyEvent.VK_BACK_QUOTE;
			
		case 'a':
			return KeyEvent.VK_A;
			
		case 'b':
			return KeyEvent.VK_B;
			
		case 'c':
			return KeyEvent.VK_C;
			
		case 'd':
			return KeyEvent.VK_D;
			
		case 'e':
			return KeyEvent.VK_E;
			
		case 'f':
			return KeyEvent.VK_F;
			
		case 'g':
			return KeyEvent.VK_G;
			
		case 'h':
			return KeyEvent.VK_H;
			
		case 'i':
			return KeyEvent.VK_I;
			
		case 'j':
			return KeyEvent.VK_J;
			
		case 'k':
			return KeyEvent.VK_K;
			
		case 'l':
			return KeyEvent.VK_L;
			
		case 'm':
			return KeyEvent.VK_M;
			
		case 'n':
			return KeyEvent.VK_N;
			
		case 'o':
			return KeyEvent.VK_O;
			
		case 'p':
			return KeyEvent.VK_P;
			
		case 'q':
			return KeyEvent.VK_Q;
			
		case 'r':
			return KeyEvent.VK_R;
			
		case 's':
			return KeyEvent.VK_S;
			
		case 't':
			return KeyEvent.VK_T;
			
		case 'u':
			return KeyEvent.VK_U;
			
		case 'v':
			return KeyEvent.VK_V;
			
		case 'w':
			return KeyEvent.VK_W;
			
		case 'x':
			return KeyEvent.VK_X;
			
		case 'y':
			return KeyEvent.VK_Y;
			
		case 'z':
			return KeyEvent.VK_Z;
			
		case '0':
			return KeyEvent.VK_0;
			
		case '1':
			return KeyEvent.VK_1;
			
		case '2':
			return KeyEvent.VK_2;
			
		case '3':
			return KeyEvent.VK_3;
			
		case '4':
			return KeyEvent.VK_4;
			
		case '5':
			return KeyEvent.VK_5;
			
		case '6':
			return KeyEvent.VK_6;
			
		case '7':
			return KeyEvent.VK_7;
			
		case '8':
			return KeyEvent.VK_8;
			
		case '9':
			return KeyEvent.VK_9;
			
		case '-':
			return KeyEvent.VK_MINUS;
			
		case '=':
			return KeyEvent.VK_EQUALS;
			
		case '[':
			return KeyEvent.VK_OPEN_BRACKET;
			
		case ']':
			return KeyEvent.VK_CLOSE_BRACKET;
			
		case '\\':
			return KeyEvent.VK_BACK_SLASH;
			
		case ';':
			return KeyEvent.VK_SEMICOLON;
			
		case '\'':
			return KeyEvent.VK_QUOTE;
			
		case ',':
			return KeyEvent.VK_COMMA;
			
		case '.':
			return KeyEvent.VK_PERIOD;
			
		default:
			//System.out.println("Error! Unrecognized character");
			//System.exit(-1);
			return -1;
		}
	}
	
	public static String translate(String code){
		String new_code = "";
		for(int ii = 0; ii < code.length(); ii++){
			char cc = code.charAt(ii);
			if(cc == '/'){
				new_code += cc;
				cc = code.charAt(++ii);
				while(cc != '/'){
					new_code += cc;
					cc = code.charAt(++ii);
				}
				new_code += cc;
			}
			else if(getKey(cc) == -1){
				if(cc >= 'A' && cc <= 'Z'){
					new_code += "/shift/";
					new_code += (char)(cc-'A'+'a');
				}
				else{
					new_code += "/shift/";
					switch(cc){
						case '~': new_code += '`';
							break;
						case '!': new_code += '1';
							break;
						case '@': new_code += '2';
							break;
						case '#': new_code += '3';
							break;
						case '$': new_code += '4';
							break;
						case '%': new_code += '5';
							break;
						case '^': new_code += '6';
							break;
						case '&': new_code += '7';
							break;
						case '*': new_code += '8';
							break;
						case '(': new_code += '9';
							break;
						case ')': new_code += '0';
							break;
						case '_': new_code += '-';
							break;
						case '+': new_code += '=';
							break;
						case '{': new_code += '[';
							break;
						case '}': new_code += ']';
							break;
						case '|': new_code += '\\';
							break;
						case ':': new_code += ';';
							break;
						case '\"': new_code += '\'';
							break;
						case '<': new_code += ',';
							break;
						case '>': new_code += '.';
							break;
						case '?': new_code += "//";
							break;
						default: System.out.println("Invalid code = " + cc);
							System.exit(-1);
							break;
					}
				}
			} else{
				new_code += cc;
			}
		}
		return new_code;
	}
	
	private static void pressKey(int key, long delay, Robot rc, boolean ctrl, boolean alt, boolean shift){
		if(ctrl)
			rc.keyPress(KeyEvent.VK_CONTROL);
		if(shift)
			rc.keyPress(KeyEvent.VK_SHIFT);
		if(alt)
			rc.keyPress(KeyEvent.VK_ALT);
		
		rc.keyPress(key);
		Basics.delay(delay);
		rc.keyRelease(key);
		
		if(ctrl){
			rc.keyRelease(KeyEvent.VK_CONTROL);
			ctrl = false;
		}
		if(shift){
			rc.keyRelease(KeyEvent.VK_SHIFT);
			shift = false;
		}
		if(alt){
			rc.keyRelease(KeyEvent.VK_ALT);
			alt = false;
		}
	}
	
	private static void pressFnKey(int fn, long delay, Robot rc, boolean ctrl, boolean alt, boolean shift){
		switch(fn){
			case 1:
				pressKey(KeyEvent.VK_F1, delay, rc, ctrl, alt, shift);
				break;
			case 2:
				pressKey(KeyEvent.VK_F2, delay, rc, ctrl, alt, shift);
				break;
			case 3:
				pressKey(KeyEvent.VK_F3, delay, rc, ctrl, alt, shift);
				break;
			case 4:
				pressKey(KeyEvent.VK_F4, delay, rc, ctrl, alt, shift);
				break;
			case 5:
				pressKey(KeyEvent.VK_F5, delay, rc, ctrl, alt, shift);
				break;
			case 6:
				pressKey(KeyEvent.VK_F6, delay, rc, ctrl, alt, shift);
				break;
			case 7:
				pressKey(KeyEvent.VK_F7, delay, rc, ctrl, alt, shift);
				break;
			case 8:
				pressKey(KeyEvent.VK_F8, delay, rc, ctrl, alt, shift);
				break;
			case 9:
				pressKey(KeyEvent.VK_F9, delay, rc, ctrl, alt, shift);
				break;
			case 10:
				pressKey(KeyEvent.VK_F10, delay, rc, ctrl, alt, shift);
				break;
			case 11:
				pressKey(KeyEvent.VK_F11, delay, rc, ctrl, alt, shift);
				break;
			case 12:
				pressKey(KeyEvent.VK_F12, delay, rc, ctrl, alt, shift);
				break;
			default:
				System.out.println("Unknown function key");
		}
	}
}
