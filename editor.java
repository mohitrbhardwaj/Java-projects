import java.awt.*;  
import java.awt.event.*;  
import java.io.*;  
import java.util.*;  
class texteditor extends Frame implements ActionListener  
{  
	TextArea ta = new TextArea();  
	int i,len1,len,pos1;  
	String str1="",str="",s3="",s2="",s4="",s32="",s6="",s7="",s8="",s9="";  
	public texteditor()  
	{  
		WindowsAdapter1 mw = new WindowsAdapter1(this);  
		addWindowListener(mw);  
		setSize(700,500); 
	 	setTitle("texteditor");  
		setVisible(true);
		setLayout(new BorderLayout());  
		add("Center",ta);  
		
		MenuBar mb=new MenuBar();
		setMenuBar(mb);
		
		String menustr[] =  new String[] {"File","Edit","Tools","Help"};
		String menuitem1str[][] =  new String[][] 
		{
			{"New","Open","Save","Print","Exit"},
			{"Delete","Cut","Copy","Paste","Select All"},
			{"Choose Environment","Compile","Build","Run"},
			{"About texteditor","Help Topics"}	
		};  
		for(int ii=0;ii<4;ii++)
		{
			Menu mm =new Menu(menustr[ii]);
			mb.add(mm);
			for(int i=0;i<menuitem1str[ii].length;i++)
			{
				MenuItem mitem  = new MenuItem(menuitem1str[ii][i]);
				mm.add(mitem);
				mitem.addActionListener(this);
			}
		}
	} 
	public void actionPerformed(ActionEvent ae)  
	{  
		String str=(String)ae.getActionCommand();  
		if(str.equals("New"))  
		{ 
		 	dispose();  
		 	texteditor t11 = new texteditor();  
			t11.setSize(700,500);  
			t11.setVisible(true);  
		}  
		try
		{  
			if(str.equals("Open"))  
			{  
			 	FileDialog fd1 = new FileDialog(this,"Select File",FileDialog.LOAD);  
				fd1.setVisible(true); 
				s3=fd1.getDirectory(); 
				s2=fd1.getFile();
				s32=s3+s2; 
				// System.out.println(s32);
				setTitle(s32);  
				FileInputStream in = null;
		  
		        in = new FileInputStream(s32);    
		        int c;
		        while((c=in.read())!=-1) 
		        {
		            char ch = (char) c;
		            s4 = s4 + ch;
		        }
			
				ta.setText(s4);  
			}  
		}  
		catch(IOException e)  
		{
		 	System.out.println("nhi chal rha");  
		}  
		try  
		{  
			if(str.equals("Save"))  
			{  
				FileDialog dialog1 = new FileDialog(this,"Save",FileDialog.SAVE);  
				dialog1.setVisible(true);  
				s7=dialog1.getDirectory();  
				s8=dialog1.getFile();
				if(s8==null)
				{
					s8="project";
				}  
				s9=s7+s8;  
				s6=ta.getText();  
				len1=s6.length();  
				byte buf[]=s6.getBytes();  
				FileOutputStream wout = new FileOutputStream(s9);  
				for(int k=0;k<len1;k++)  
				{  
				 	wout.write(buf[k]);  
				}  
				wout.close();  
			}  
			this.setTitle(s8 +" texteditor File");  
		}  
		catch(IOException e)
		{

		}  
		try
		{
			if(str.equals("Help Topics"))
			{
				// System.out.println("chala");
				Runtime.getRuntime().exec( String.format("gnome-open %s", new File("/home/mohitrbhardwaj/Desktop/helpdoc.html")) );
			}
		}
		catch(IOException e)
		{

		}
		try
		{
			if(str.equals("About texteditor"))
			{
				// System.out.println("chala");
				Runtime.getRuntime().exec( String.format("gnome-open %s", new File("/home/mohitrbhardwaj/Desktop/abouttexteditor.html")) );
			}
		}
		catch(IOException e)
		{

		}
		try
		{
			if(str.equals("Compile"))
			{
				// System.out.println("chala");
				// String htr="/bin/bash -c g++ ";
				// htr=htr+s9;
				// System.out.println(htr);
				if(s9.length()>0)
				{
					int lennn=s9.length();
					String sdr= s9.substring(lennn-2,lennn);
					System.out.println(sdr);
					if(sdr.equals("pp"))
					{
						String[] command = { "xterm", "-e", "g++", s9 };
						Runtime.getRuntime().exec(command);
					}
					else if(sdr.equals("py"))
					{
						String[] command = { "xterm", "-e", "python", s9 };
						Runtime.getRuntime().exec(command);
					}
					
				}
				else if(s32.length()>0)
				{
					int lennn=s32.length();
					String sdr= s32.substring(lennn-2,lennn);
					System.out.println(sdr);
					if(sdr.equals("pp"))
					{
						String[] command = { "xterm", "-e", "g++", s32 };
						Runtime.getRuntime().exec(command);
					}
					else if(sdr.equals("py"))
					{
						String[] command = { "xterm", "-e", "python", s32 };
						Runtime.getRuntime().exec(command);
					}
						
				}
			}
		}
		catch(IOException e)
		{

		}
		try
		{
			if(str.equals("Run"))
			{
				// System.out.println("chalajkjkjk");
				if(s32.length()>0)
				{
					int lennn=s32.length();
					String sdr = s32.substring(lennn-2,lennn);
					if(sdr.equals("pp"))
					{
						String[] command = { "xterm", "-e", "./a.out" };
						Runtime.getRuntime().exec(command);
					}
				}
				else if(s9.length()>0)
				{
					int lennn=s9.length();
					String sdr = s9.substring(lennn-2,lennn);
					if(sdr.equals("pp"))
					{
						String[] command = { "xterm", "-e", "./a.out" };
						Runtime.getRuntime().exec(command);
					}
				}
			}
		}
		catch(IOException e)
		{

		}
		if(str.equals("Exit"))  
		{  
			System.exit(0);  
		}  
		if(str.equals("Cut"))  
		{  
			String msg=ta.getSelectedText();  
			i=ta.getText().indexOf(msg);  
			ta.replaceRange("",i,i+msg.length());  
			str1=msg;
			msg=""; 
		}  
		if(str.equals("Copy"))  
		{  
			str1=ta.getSelectedText();  
		}  
		if(str.equals("Paste"))  
		{  
			pos1=ta.getCaretPosition();  
			ta.insert(str1,pos1);  
		}  
		if(str.equals("Delete"))  
		{  
			String msg=ta.getSelectedText();  
			i=ta.getText().indexOf(msg);  
			ta.replaceRange("",i,i+msg.length());  
			msg="";  
		}  
		if(str.equals("Select All"))  
		{  
			String strText = ta.getText();  
			int strLen = strText.length();  
			ta.select(0,strLen);  
		}  
	} 
	public class WindowsAdapter1 extends WindowAdapter  
	{  
		texteditor tt;  
		public WindowsAdapter1(texteditor ttt)  
		{  
			tt=ttt;  
		}  
		public void windowClosing(WindowEvent we)  
		{  
			tt.dispose();  
		}  
	}  
}  
public class editor  
{
	public static void main(String args[])  
	{  
		texteditor t_edit = new texteditor();  
	}  
}  
