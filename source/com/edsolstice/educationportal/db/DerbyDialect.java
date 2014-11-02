package com.edsolstice.educationportal.db;

import org.hibernate.HibernateException;
/** 
 *  (c) Copyright Hewlett-Packard Company. 2010-2011. All rights reserved.
 *  Copying or other reproduction of this program except for archival purposes
 *  is prohibited without prior written consent of Hewlett-Packard Company.
 *  
 * <p>Title: DerbyDialect</p>
 * <p>Copyright: Copyright (c) 2011-2012</p>
 * <p>Company: Hewlett-Packard Company</p>
 * @version 1.0
 * @author Nitin Patidar
 */
public class DerbyDialect extends org.hibernate.dialect.DerbyDialect {

	public DerbyDialect() {
		super();
	}


	public String getTypeName(final int code, final int length, final int precision, final int scale) throws HibernateException {
       
		String typeName = super.getTypeName(code, length, precision, scale);
		if (code == -3) {
			typeName = "LONG VARCHAR FOR BIT DATA";
		}

		return typeName;
	}
}



