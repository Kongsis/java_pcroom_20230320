package java_project;

import java.util.*;

public class PcroomRepository {
	private static PcroomRepository repository = new PcroomRepository(); // 싱글톤(접근제한)
	private PcroomRepository() {}
	public static PcroomRepository getInstance() {
		return repository;
	}
	
	List<PcroomDTO> list = new ArrayList<>();
	
}
