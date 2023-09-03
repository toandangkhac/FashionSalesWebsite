package ptithcm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ptithcm.entity.LoaiSanPhamEntity;

@Repository
public class loaiSanPhamDAOIml implements loaiSanPhamDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public LoaiSanPhamEntity layLoaiTheoMa(String maLoai) {
		Session session = sessionFactory.getCurrentSession();
	    LoaiSanPhamEntity loai = (LoaiSanPhamEntity) session.get(LoaiSanPhamEntity.class, maLoai);
	    return loai;
	}

	@Override
	public List<LoaiSanPhamEntity> layLoai() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM LoaiSanPhamEntity";
		Query query = session.createQuery(hql);
	    List<LoaiSanPhamEntity> listLoai = query.list();
	    return listLoai;
	}

	@Override
	public List<LoaiSanPhamEntity> layLoaiTheoGioiTinh(String gioiTinh) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM LoaiSanPhamEntity where tenLoai LIKE :gioiTinh ";
		Query query = session.createQuery(hql).setParameter("gioiTinh", "%" +gioiTinh+"%");
	    List<LoaiSanPhamEntity> listLoai = query.list();
	    return listLoai;
	}

}
