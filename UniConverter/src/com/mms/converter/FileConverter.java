package com.mms.converter;

import static com.mms.util.MString.getUni2Z;
import static com.mms.util.MString.getZ2Uni;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
		this.init(new File(pathin));
	}

	public FileConverter(File file, FILE_TYPE type) throws IOException {
		inList = new ArrayList<String>();
		outList = new ArrayList<String>();
		this.inFileType = type;
		this.init(file);
	}

	private void init(File f) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(f));
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
		
		for(int i=0; i <lines.size(); i++) {
			bw.write(lines.get(i));
			if(i != lines.size() -1)
				bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	public void writeConvertFile(String outPath) throws IOException {
		if(this.inFileType.equals(FILE_TYPE.ZAWGYI)) {
			this.writeUniFile(outPath);
		} else {
			this.writeZawGyiFile(outPath);
		}
	}
}
