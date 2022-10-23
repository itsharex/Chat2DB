package com.alibaba.dataops.server.web.api.controller.mysql;

import java.util.List;

import com.alibaba.dataops.server.domain.core.api.param.DataSourceExecuteParam;
import com.alibaba.dataops.server.domain.core.api.service.DataSourceCoreService;
import com.alibaba.dataops.server.domain.data.api.model.ExecuteResultDTO;
import com.alibaba.dataops.server.tools.base.wrapper.result.ActionResult;
import com.alibaba.dataops.server.tools.base.wrapper.result.DataResult;
import com.alibaba.dataops.server.tools.base.wrapper.result.ListResult;
import com.alibaba.dataops.server.tools.base.wrapper.result.web.WebPageResult;
import com.alibaba.dataops.server.web.api.aspect.BusinessExceptionAspect;
import com.alibaba.dataops.server.web.api.controller.mysql.converter.RdbDataConverter;
import com.alibaba.dataops.server.web.api.controller.mysql.request.TableBriefQueryRequest;
import com.alibaba.dataops.server.web.api.controller.mysql.request.TableDeleteRequest;
import com.alibaba.dataops.server.web.api.controller.mysql.request.TableDetailQueryRequest;
import com.alibaba.dataops.server.web.api.controller.mysql.request.TableManageRequest;
import com.alibaba.dataops.server.web.api.controller.mysql.request.TableSqlExportRequest;
import com.alibaba.dataops.server.web.api.controller.mysql.vo.ExecuteResultVO;
import com.alibaba.dataops.server.web.api.controller.mysql.vo.TableVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mysql表运维类
 *
 * @author moji
 * @version MysqlTableManageController.java, v 0.1 2022年09月16日 17:41 moji Exp $
 * @date 2022/09/16
 */
@BusinessExceptionAspect
@RequestMapping("/api/rdb/table")
@RestController
public class RdbTableManageController {

    @Autowired
    private DataSourceCoreService dataSourceCoreService;

    @Autowired
    private RdbDataConverter rdbDataConverter;

    /**
     * 查询当前DB下的表列表
     *
     * @param request
     * @return
     */
    @GetMapping("/list")
    public WebPageResult<TableVO> list(TableBriefQueryRequest request) {
        return null;
    }

    /**
     * 导出建表语句
     *
     * @param request
     * @return
     */
    @GetMapping("/export")
    public DataResult<String> export(TableSqlExportRequest request) {
        return null;
    }

    /**
     * 获取表下列和索引等信息
     *
     * @param request
     * @return
     */
    @GetMapping("/query")
    public DataResult<TableVO> query(TableDetailQueryRequest request) {
        return null;
    }

    /**
     * 增删改等表运维
     *
     * @param request
     * @return
     */
    @PutMapping("/manage")
    public ListResult<ExecuteResultVO> manage(@RequestBody TableManageRequest request) {
        DataSourceExecuteParam param = rdbDataConverter.tableRequest2param(request);
        ListResult<ExecuteResultDTO> resultDTOListResult = dataSourceCoreService.execute(param);
        List<ExecuteResultVO> resultVOS = rdbDataConverter.dto2vo(resultDTOListResult.getData());
        return ListResult.of(resultVOS);
    }

    /**
     * 删除表
     *
     * @param request
     * @return
     */
    @DeleteMapping("/delete")
    public ActionResult delete(@RequestBody TableDeleteRequest request) {
        return null;
    }
}