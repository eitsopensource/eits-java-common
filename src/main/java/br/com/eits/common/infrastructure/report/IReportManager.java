/**
 * 
 */
package br.com.eits.common.infrastructure.report;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.sql.DataSource;

import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

/**
 * @author rodrigo
 *
 */
public interface IReportManager
{
	/*-------------------------------------------------------------------
	 *				 		     BEAHAVIORS
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 * @param parameters
	 * @param reportPath 
	 */
	public ByteArrayOutputStream exportToPDF( Map<String, Object> parameters, String reportPath );
	
	/**
	 * 
	 * @param parameters
	 * @param reportPath
	 */
	public ByteArrayOutputStream exportToHTML( Map<String, Object> parameters, String reportPath );
	
	/**
	 * 
	 * @param parameters
	 * @param reportPath
	 */
	public ByteArrayOutputStream exportToXML( Map<String, Object> parameters, String reportPath );
	
	/**
	 * 
	 * @param parameters
	 * @param reportPath
	 */
	public ByteArrayOutputStream exportToXLS( Map<String, Object> parameters, String reportPath );
	
	/**
	 * 
	 * @param parameters
	 * @param reportPath
	 */
	public ByteArrayOutputStream exportToXLS( Map<String, Object> parameters, String reportPath, SimpleXlsReportConfiguration configuration );	
	
	/*-------------------------------------------------------------------
	 *				 		 GETTERS AND SETTERS
	 *-------------------------------------------------------------------*/  
	/**
	 * 
	 * @param dataSource
	 */
	public void setDataSource( DataSource dataSource );
}
