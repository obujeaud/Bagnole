package service;

import java.util.List;

import dao.BagnoleDao;
import entity.BagnoleEntity;

public class VoitureService {
	BagnoleDao bdao = new BagnoleDao();
	private static VoitureService vs = null;
	
	private VoitureService() {
		
	}
	
	public static VoitureService getInstance() {
		if(vs == null) {
			vs = new VoitureService();
		}
		return vs;
	}
	
	public List<BagnoleEntity> list(){
		return bdao.list();
	}
	
	public BagnoleEntity getById(long id) {
		return bdao.getById(id);
	}
	
	public void add(BagnoleEntity b) {
		bdao.save(b);
	}
	
	public void replace(BagnoleEntity be) {
		boolean isInside = false;
		for (BagnoleEntity b : bdao.list()) {
			if (b.getId() == be.getId()) {
				isInside = true;
				b = be;
			}
		}
		if(!isInside) {
			add(be);
		}
	}
	
	public void delete(long b) throws Exception {
		bdao.deleteById(b);
	}

}
