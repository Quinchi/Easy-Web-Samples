
package com.custpurchasedb;

import java.util.List;
import com.wavemaker.json.type.TypeDefinition;
import com.wavemaker.runtime.data.DataServiceManager;
import com.wavemaker.runtime.data.DataServiceManagerAccess;
import com.wavemaker.runtime.data.TaskManager;
import com.wavemaker.runtime.service.LiveDataService;
import com.wavemaker.runtime.service.PagingOptions;
import com.wavemaker.runtime.service.PropertyOptions;
import com.wavemaker.runtime.service.TypedServiceReturn;

//Added for use of annotation
import com.wavemaker.runtime.service.annotations.HideFromClient;

/**
 *  Operations for service "custpurchaseDB"
 *  03/05/2013 19:55:42
 * 
 */
@SuppressWarnings("unchecked")
public class CustpurchaseDB
    implements DataServiceManagerAccess, LiveDataService
{

    private DataServiceManager dsMgr;
    private TaskManager taskMgr;

    public com.custpurchasedb.data.Cpuser getCpuserById(String id, PagingOptions pagingOptions) {
        List<com.custpurchasedb.data.Cpuser> rtn = ((List<com.custpurchasedb.data.Cpuser> ) dsMgr.invoke(taskMgr.getQueryTask(), (CustpurchaseDBConstants.getCpuserByIdQueryName), id, pagingOptions));
        if (rtn.isEmpty()) {
            return null;
        } else {
            return rtn.get(0);
        }
    }

    @HideFromClient
    public Object insert(Object o) {
        return dsMgr.invoke(taskMgr.getInsertTask(), o);
    }

    public TypedServiceReturn read(TypeDefinition rootType, Object o, PropertyOptions propertyOptions, PagingOptions pagingOptions) {
        return ((TypedServiceReturn) dsMgr.invoke(taskMgr.getReadTask(), rootType, o, propertyOptions, pagingOptions));
    }

    @HideFromClient
    public Object update(Object o) {
        return dsMgr.invoke(taskMgr.getUpdateTask(), o);
    }

    @HideFromClient
    public void delete(Object o) {
        dsMgr.invoke(taskMgr.getDeleteTask(), o);
    }

    @HideFromClient
    public void begin() {
        dsMgr.begin();
    }

    @HideFromClient
    public void commit() {
        dsMgr.commit();
    }

    @HideFromClient
    public void rollback() {
        dsMgr.rollback();
    }

    @HideFromClient
    public DataServiceManager getDataServiceManager() {
        return dsMgr;
    }

    @HideFromClient
    public void setDataServiceManager(DataServiceManager dsMgr) {
        this.dsMgr = dsMgr;
    }

    @HideFromClient
    public TaskManager getTaskManager() {
        return taskMgr;
    }

    @HideFromClient
    public void setTaskManager(TaskManager taskMgr) {
        this.taskMgr = taskMgr;
    }

}