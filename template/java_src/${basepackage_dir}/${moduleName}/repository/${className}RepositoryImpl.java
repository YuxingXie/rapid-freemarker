<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.repository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<#include "/java_imports.include">

public class ${className}RepositoryImpl{
	@PersistenceContext
	private EntityManager em;
	public int updateMethodAs(){
		String update="update ${className} ${classNameLower} set ${classNameLower}.name='George James' where ${classNameLower}.name='James'";
		return em.createQuery(update).executeUpdate();
	}
}
