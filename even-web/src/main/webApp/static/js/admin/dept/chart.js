var echart= {
    init:function () {
        Ep.ajax({
            url:'/department/list',
            succFunc:function (result) {
                var treeData=[];//格式化数据为echart树形结构
                var topNodes=[];//顶级节点

                //echart树形图配置
                $.each(result.data,function (i,o) {
                    var node={};
                    node.id=o.id;
                    node.pid=o.parentId;
                    node.name=o.deptName;
                    node.symbolSize=[70, 30];
                    node.symbol='rectangle';
                    node.itemStyle={
                        normal: {
                            label: {
                                show: true,
                                position: 'inside'
                            },
                            borderWidth: 2,
                            borderColor: 'black'
                        }
                    };
                    node.children=[];
                    treeData.push(node);
                });
                //载入children子集
                $.each(treeData,function (i, children) {
                    var pid = children.pid;
                    if (pid==0){
                        topNodes.push(children);
                        return true;
                    }
                    $.each(treeData,function (j,parent) {
                        var id = parent.id;
                        if (id && id == pid){
                            parent.children.push(children);
                            return true;
                        }
                    })
                });
                echart.loadEchart(topNodes);
            }
        });
    },
    loadEchart: function (data) {
        var myChart = echarts.init(document.getElementById('chart'));
        var option = {
            title: {
                text: '组织架构图'
            },
            tooltip: {
                show: false,
                trigger: 'item',
                formatter: "{b}: {c}"
            },
            toolbox: {
                show: true,
                feature: {
                    saveAsImage: {show: true}
                }
            },
            calculable: false,
            series: [
                {
                    name: '树图',
                    type: 'tree',
                    orient: 'vertical',  // vertical horizontal
                    rootLocation: {x: '50%', y: '15%'}, // 根节点位置  {x: 'center',y: 10}
                    nodePadding: 20,
                    layerPadding: 40,
                    symbol: 'rectangle',
                    borderColor: 'black',
                    itemStyle: {
                        normal: {
                            color: '#fff',//节点背景色
                            label: {
                                show: true,
                                position: 'inside',
                                textStyle: {
                                    color: 'black',
                                    fontSize: 15,
                                    //fontWeight:  'bolder'
                                }
                            },
                            lineStyle: {
                                color: '#000',
                                width: 1,
                                type: 'broken' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
                            }
                        },
                        emphasis: {
                            label: {
                                show: false
                            }
                        }
                    },
                    data: data
                }
            ]
        };
        myChart.setOption(option);
    }
}
$(function(){
    echart.init();
});