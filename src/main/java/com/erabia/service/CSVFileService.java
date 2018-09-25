package com.erabia.service;

import java.util.List;
import java.util.Map;

public interface CSVFileService {
	public List<Map<Integer, String>> readFile(String filePath, String seperator);

	public void addRecord(String name, int id, int scrore, String fileName);

	public void addAllRecords(List<String> studentInfoRecord, String fileName);

}
