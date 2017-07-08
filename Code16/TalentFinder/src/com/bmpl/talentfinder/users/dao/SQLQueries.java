package com.bmpl.talentfinder.users.dao;

public interface SQLQueries {
	String LOGIN_QUERY = "select um.userid,rm.name as 'rolename',rr.name as 'rightname'"
			+ ",rr.screenname"
			+ " from user_master um,role_master rm, right_master rr, "
			+ "user_role_mapping userrole, role_right_mapping roleright "
			+ "where um.userid=? and um.password=? and"
			+ " um.status='A' and um.uid=userrole.uid "
			+ "and rm.roleid=userrole.roleid "
			+ "and rm.roleid=roleright.roleid and "
			+ "rr.rightid=roleright.rightid and roleright.status='A'";
}
