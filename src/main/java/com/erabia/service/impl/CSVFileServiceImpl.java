package com.erabia.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.erabia.service.CSVFileService;

public class CSVFileServiceImpl implements CSVFileService {

	@Override
	public List<Map<Integer, String>> readFile(String filePath, String seperator) {
		
		if(filePath==null || filePath.isEmpty())
		{
			throw new IllegalArgumentException("filePath is must be not null");
		}
		
		if(seperator==null || seperator.isEmpty())
		{
			throw new IllegalArgumentException("seperator is must be not null");
		}
		
		
		List<Map<Integer, String>> recordsList = new ArrayList<>();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filePath));
			while (scanner.hasNextLine()) {
				String[] split = scanner.nextLine().split(seperator);
				
				Map<Integer, String>  record = new HashMap<Integer, String>();
				
				for (int i = 0; i < split.length; i++) {
					record.put(i, split[i]);
				}

				recordsList.add(record);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}

		return recordsList;
	}

	@Override
	public void addRecord(String name, int id, int scrore, String fileName) {
		File file = new File(fileName);
		String addedRecrod = id + "," + name + "," + scrore;
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			PrintWriter printwriter = new PrintWriter(bw);
			printwriter.println(addedRecrod);
			printwriter.flush();
			printwriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addAllRecords(List<String> studentInfoRecords, String fileName) {
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			PrintWriter printwriter = new PrintWriter(bw);
			
			for (String studentInfoRecord : studentInfoRecords) {
				printwriter.println(studentInfoRecord);
			}

			printwriter.flush();
			printwriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
