package com.ebi.person.common;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * UUID generator strategy.
 * 
 * @author sulaimat
 */
public class UUIDGeneratorStrategy implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return UUID.randomUUID().toString();
	}

}
