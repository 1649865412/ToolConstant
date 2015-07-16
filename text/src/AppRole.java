

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Model class for AppRole. Add not database mapped fileds in this class.
 */
public class AppRole {
	
    protected Integer appRoleId;
	protected String roleName;
	protected String roleDetail;
	protected java.util.Date createTime;
	protected java.util.Date updateTime;
	protected Short status;
	protected Short isSystem;
	protected Integer version;
	public Integer getAppRoleId()
	{
		return appRoleId;
	}
	public void setAppRoleId(Integer appRoleId)
	{
		this.appRoleId = appRoleId;
	}
	public String getRoleName()
	{
		return roleName;
	}
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
	public String getRoleDetail()
	{
		return roleDetail;
	}
	public void setRoleDetail(String roleDetail)
	{
		this.roleDetail = roleDetail;
	}
	public java.util.Date getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime)
	{
		this.createTime = createTime;
	}
	public java.util.Date getUpdateTime()
	{
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime)
	{
		this.updateTime = updateTime;
	}
	public Short getStatus()
	{
		return status;
	}
	public void setStatus(Short status)
	{
		this.status = status;
	}
	public Short getIsSystem()
	{
		return isSystem;
	}
	public void setIsSystem(Short isSystem)
	{
		this.isSystem = isSystem;
	}
	public Integer getVersion()
	{
		return version;
	}
	public void setVersion(Integer version)
	{
		this.version = version;
	}
	
	
	
}
