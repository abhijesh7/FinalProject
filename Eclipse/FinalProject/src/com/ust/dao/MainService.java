package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.Model;

public class MainService implements IMainService {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;

	}

	// Login
	/* (non-Javadoc)
	 * @see com.ust.dao.IMainService#verifyLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public Model verifyLogin(String username, String password) {

		String sql = "select userId from ustLoginTable where username = ? and password = ?";
		Model mod= template.queryForObject(sql,
				new Object[] { username, password },
				new BeanPropertyRowMapper<Model>(Model.class));
		int userId=mod.getUserId();
		return mod;
	}

	// Insert vendor
	/* (non-Javadoc)
	 * @see com.ust.dao.IMainService#vendorInsert(com.ust.model.Model)
	 */
	@Override
	public int vendorInsert(Model mod) {
		String sql = "insert into vendorTable(vName,address,location,service,pincode,vIsActive) values(?,?,?,?,?,1)";
		template.update(sql, new Object[] { mod.getvName(), mod.getAddress(),
				mod.getLocation(), mod.getService(), mod.getPincode() });

		String sql1 = "select max(vId) from vendorTable";
		int vId = template.queryForObject(sql1, Integer.class);
		String sql2 = "insert into contactTable(vId,cName,department,email,phone,cIsActive) values(?,?,?,?,?,1)";
		return template.update(
				sql2,
				new Object[] { vId, mod.getcName(), mod.getDepartment(),
						mod.getEmail(), mod.getPhone() });

	}
	
	//View vendor details
	/* (non-Javadoc)
	 * @see com.ust.dao.IMainService#vendorList()
	 */
	@Override
	public List<Model> vendorList() {
		return template
				.query("select vId,vName,address,location,service,pincode,vIsActive,cId,cName,department,email,phone from vendorTable join contactTable using(vId) where vIsActive!='0'",
						new RowMapper<Model>() {

							@Override
							public Model mapRow(ResultSet rs, int row)
									throws SQLException {
								// TODO Auto-generated method stub

								Model mod = new Model();
								mod.setvId(rs.getInt(1));
								mod.setvName(rs.getString(2));
								mod.setAddress(rs.getString(3));
								mod.setLocation(rs.getString(4));
								mod.setService(rs.getString(5));
								mod.setPincode(rs.getString(6));
								mod.setvIsActive(rs.getString(7));
								mod.setcId(rs.getInt(8));
								mod.setcName(rs.getString(9));
								mod.setDepartment(rs.getString(10));
								mod.setEmail(rs.getString(11));
								mod.setPhone(rs.getString(12));
								return mod;
							}
						});

	}
	//view by vId
	
		/* (non-Javadoc)
		 * @see com.ust.dao.IMainService#vendorListId(int)
		 */
		@Override
		public List<Model> vendorListId(int vId) {
			return template
					.query("select vId,vName,address,location,service,pincode,vIsActive,cId,cName,department,email,phone from vendorTable join contactTable using(vId) where vId="+vId+"",
							new RowMapper<Model>() {

								@Override
								public Model mapRow(ResultSet rs, int row)
										throws SQLException {
									// TODO Auto-generated method stub

									Model mod = new Model();
									mod.setvId(rs.getInt(1));
									mod.setvName(rs.getString(2));
									mod.setAddress(rs.getString(3));
									mod.setLocation(rs.getString(4));
									mod.setService(rs.getString(5));
									mod.setPincode(rs.getString(6));
									mod.setvIsActive(rs.getString(7));
									mod.setcId(rs.getInt(8));
									mod.setcName(rs.getString(9));
									mod.setDepartment(rs.getString(10));
									mod.setEmail(rs.getString(11));
									mod.setPhone(rs.getString(12));
									return mod;
								}
							});

		}

	
	//Edit vendor details
	/* (non-Javadoc)
	 * @see com.ust.dao.IMainService#updatevendor(com.ust.model.Model)
	 */
	@Override
	public int updatevendor(Model mod)
	{
		String sql="update vendorTable set vName=?,address=?,location=?,service=?,pincode=?,vIsActive=? where vId=?";
		template.update(sql,new Object[] {mod.getvName(),mod.getAddress(),mod.getLocation(),mod.getService(),mod.getPincode(),mod.getvIsActive(),mod.getvId()});
		String sql1="update contactTable set cName=?,department=?,email=?,phone=? where vId=?";
		return template.update(sql1, new Object[] {mod.getcName(),mod.getDepartment(),mod.getEmail(),mod.getPhone(),mod.getvId()});
	}
	
	
	//Disable vendor
	 /* (non-Javadoc)
	 * @see com.ust.dao.IMainService#disableVendor(int)
	 */
	@Override
	public int disableVendor(int vId) {
		    String sql = "update vendorTable set vIsActive = '0'  where vId = '" + vId + "'";
		    return template.update(sql);
		    }
	
	 //Search
	 /* (non-Javadoc)
	 * @see com.ust.dao.IMainService#vendorSearch(java.lang.String)
	 */
	@Override
	public List<Model> vendorSearch(String search) {
			return template
					.query("select vId,vName,address,location,service,pincode,vIsActive,cId,cName,department,email,phone from vendorTable join contactTable using(vId) where location like'"
							+ search + "%' or vName like'" + search + "%' or service like'" + search + "%'"  ,
							new RowMapper<Model>() {

								@Override
								public Model mapRow(ResultSet rs, int row)
										throws SQLException {
									Model mod = new Model();
									mod.setvId(rs.getInt(1));
									mod.setvName(rs.getString(2));
									mod.setAddress(rs.getString(3));
									mod.setLocation(rs.getString(4));
									mod.setService(rs.getString(5));
									mod.setPincode(rs.getString(6));
									mod.setvIsActive(rs.getString(7));
									mod.setcId(rs.getInt(8));
									mod.setcName(rs.getString(9));
									mod.setDepartment(rs.getString(10));
									mod.setEmail(rs.getString(11));
									mod.setPhone(rs.getString(12));
									return mod;
								}

							});
		}
	 
	 //Sort by vId
	 /* (non-Javadoc)
	 * @see com.ust.dao.IMainService#sortedList1()
	 */
	@Override
	public List<Model> sortedList1() {
			return template
					.query("select vId,vName,address,location,service,pincode,vIsActive,cId,cName,department,email,phone from vendorTable join contactTable using(vId) order by vId",
							new RowMapper<Model>() {

								@Override
								public Model mapRow(ResultSet rs, int row)
										throws SQLException {
									// TODO Auto-generated method stub

									Model mod = new Model();
									mod.setvId(rs.getInt(1));
									mod.setvName(rs.getString(2));
									mod.setAddress(rs.getString(3));
									mod.setLocation(rs.getString(4));
									mod.setService(rs.getString(5));
									mod.setPincode(rs.getString(6));
									mod.setvIsActive(rs.getString(7));
									mod.setcId(rs.getInt(8));
									mod.setcName(rs.getString(9));
									mod.setDepartment(rs.getString(10));
									mod.setEmail(rs.getString(11));
									mod.setPhone(rs.getString(12));
									return mod;
								}
							});

		}
	 
	 //Sort by vName
	 /* (non-Javadoc)
	 * @see com.ust.dao.IMainService#sortedList2()
	 */
	@Override
	public List<Model> sortedList2() {
			return template
					.query("select vId,vName,address,location,service,pincode,vIsActive,cId,cName,department,email,phone from vendorTable join contactTable using(vId) order by vName",
							new RowMapper<Model>() {

								@Override
								public Model mapRow(ResultSet rs, int row)
										throws SQLException {
									// TODO Auto-generated method stub

									Model mod = new Model();
									mod.setvId(rs.getInt(1));
									mod.setvName(rs.getString(2));
									mod.setAddress(rs.getString(3));
									mod.setLocation(rs.getString(4));
									mod.setService(rs.getString(5));
									mod.setPincode(rs.getString(6));
									mod.setvIsActive(rs.getString(7));
									mod.setcId(rs.getInt(8));
									mod.setcName(rs.getString(9));
									mod.setDepartment(rs.getString(10));
									mod.setEmail(rs.getString(11));
									mod.setPhone(rs.getString(12));
									return mod;
								}
							});

		}
	 
}
