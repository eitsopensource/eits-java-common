package br.com.eits.common.infrastructure.dbunit;

import org.springframework.core.annotation.Order;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TestExecutionListenerChain;

/**
 * 
 * @author rodrigo
 * @deprecated Please use the sprint test @SQL
 */
@Order(10)
public class TransactionDbUnitTestExecutionListener extends TestExecutionListenerChain
{
	/**
	 * 
	 */
	private static final Class<?>[] CHAIN = { TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class };

	/**
	 * 
	 */
	@Override
	protected Class<?>[] getChain()
	{
		return TransactionDbUnitTestExecutionListener.CHAIN;
	}

}