package com.mms.converter;

import static com.mms.util.MString.getUni2Z;
import static com.mms.util.MString.getZ2Uni;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mms.util.FILE_TYPE;

public class FileConverter {

	private List<String> inList;
	private List<String> outList;
	private FILE_TYPE inFileType;
	
	public FileConverter(String pathin, FILE_TYPE type) throws IOException {
		inList = new ArrayList<String>();
		outList = new ArrayList<String>();
		this.inFileType = type;
		
		BufferedReader br = new BufferedReader(new FileReader(pathin));
		String line = null;
		while((line = br.readLine()) != null) {
			inList.add(line);
			if (inFileType.equals(FILE_TYPE.ZAWGYI)) 
				outList.add(getZ2Uni(line));
			else 
				outList.add(getUni2Z(line));
		}
	}

	public List<String> getUniList() {
		if (inFileType.equals(FILE_TYPE.ZAWGYI))
			return outList;
		return inList;
	}
	
	public List<String> getZawGyiList() {
		if (inFileType.equals(FILE_TYPE.ZAWGYI))
			return inList;
		return outList;
	}
	
	public void writeUniFile(String path) throws IOException {
		if (inFileType.equals(FILE_TYPE.ZAWGYI))
			this.writeFile(path, outList);
		else
			this.writeFile(path, inList);
	}

	public void writeZawGyiFile(String path) throws IOException {
		if (inFileType.equals(FILE_TYPE.ZAWGYI))
			this.writeFile(path, inList);
		else
			this.writeFile(path, outList);
	}
	
	private void writeFile(String path, List<String> lines) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		for(String line : lines) {
			bw.write(line);
		}
		bw.flush();
		bw.close();
	}
	
	public static void main(String[] args) {
		try {
			FileConverter fc = new FileConverter("zawgyiFile.txt", FILE_TYPE.ZAWGYI);
			List<String> uniList = fc.getUniList();
			for(String s : uniList)
				System.out.println(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
