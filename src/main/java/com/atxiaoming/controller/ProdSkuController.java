package com.atxiaoming.controller;


import com.atxiaoming.entity.ProdSku;
import com.atxiaoming.service.impl.ProdSkuServiceImpl;
import com.atxiaoming.vo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 小明
 * @since 2021-01-15
 */
@Api(description = "产品库存相关接口")
@RestController
@RequestMapping("/prodSku")
@Slf4j
public class ProdSkuController {

    @Autowired
    private ProdSkuServiceImpl prodSkuServiceImpl;

    @ApiOperation(value = "添加产品库存" ,  notes="添加产品库存")
    @RequestMapping(value="/add",method= RequestMethod.POST)
    public RespBean addProdSku(@RequestBody List<ProdSku> prodSkus){
        return prodSkuServiceImpl.addProdSku(prodSkus);
    }

    @ApiOperation(value = "获取产品库存" ,  notes="获取产品库存")
    @RequestMapping(value="/getSku",method= RequestMethod.POST)
    public RespBean getSku(@RequestParam("prodId") Integer prodId){
        return prodSkuServiceImpl.getProdSku(prodId);
    }

    @ApiOperation(value = "修改产品库存" ,  notes="修改产品库存")
    @RequestMapping(value="/edit",method= RequestMethod.POST)
    public RespBean editProdSku(@RequestBody List<ProdSku> prodSkus){
        return prodSkuServiceImpl.editProdSku(prodSkus);
    }

}
