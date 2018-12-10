package ui.model;

import java.util.List;

import javax.swing.AbstractListModel;

import entity.BagnoleEntity;
import service.VoitureService;

@SuppressWarnings("serial")
public class VoitureModeleList<E> extends AbstractListModel<E> {
	public VoitureService l = VoitureService.getInstance();
	
	public VoitureModeleList(VoitureService v) {
		// TODO Auto-generated constructor stub
		l = v;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return l.list().size();
	}
	
	public List<BagnoleEntity> list(){
		return l.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getElementAt(int index) {
		// TODO Auto-generated method stub
		return (E) l.list().get(index);
	}

}
