<!DOCTYPE html>
<html>

<head>
<%@ page contentType="text/html;charset=utf-8"%>
<link rel="stylesheet" type="text/css"
	href="../jquery-easyui-1.7.0/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="../jquery-easyui-1.7.0/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="../css/index.css" />
<script src="../jquery-easyui-1.7.0/jquery.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="../jquery-easyui-1.7.0/jquery.easyui.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="../js/index.js" type="text/javascript" charset="utf-8"></script>
<title>运维分析平台</title>

</head>

<body>

	<div class="easyui-layout" data-options="fit:true"
		style="width: 800px; height: 600px;">
		<div id="nor" region="north" style="overflow:hidden">
			<div id="logo"><img src="../image/logo.png"></div>
			<div id="bt">智能运维分析平台</div>
			<div id="mk1" onclick="addNewTab('XX1','www.baidu.com')"><div><img src="../image/home.png"></div></div>
			<div id="mk2" onclick="addNewTab('XX2','www.baidu.com')"><div><img src="../image/set.png"></div></div>
			<div id="mk3" onclick="addNewTab('XX3','www.baidu.com')"><div><img src="../image/message.png"></div></div>
			<div id="mk4"><div>
			<img src="../image/search.png">
			</div></div>
			<div id="mk5" onclick="addNewTab('XX5','www.baidu.com')"><div><img src="../image/avatar.png"></div></div>
		</div>
		<!--左侧菜单start-->
		<div region="west" title="导航" split="true" style="width: 200px;">
			<div class="easyui-panel" data-options="fit:true">
				<!-- 手风琴菜单 -->
				<div id="ac" class="easyui-accordion" data-options="fit:true,iconCls:'icon-ok'">
					<!-- data-options="iconCls:'icon-ok'" -->
					<div title="数据展示" style="overflow:auto; padding: 20px">
						
						
						 <ul id="tt" class="easyui-tree">
							<li><span>Folder</span>
								<ul>
									<li><span>展示</span>
										<ul>
											<li><span>File11</span></li>
											<li><span>File12</span></li>
										</ul>
									</li>
									<li><span>配置</span>
										<ul>
											<li><span>File21</span></li>
											<li><span>File22</span></li>
										</ul>
									</li>
									<li><span>后台管理</span>
										<ul>
											<li><span>File31</span></li>
											<li><span>File32</span></li>
										</ul>
									</li>
								</ul>
							</li>
						</ul>
					</div>
					<div title="数据预处理" style="padding: 10px;">

						<!-- <p onclick="addNewTab('XX1','localhost:8080/mei/city/showAll')" style="cursor: pointer">Java</p> -->
						
						<ul id="tt1" class="easyui-tree">
							<li><span>Folder</span>
								<ul>
									<li><span>趋势分析</span>
										<ul>
											<li><span>Trend</span></li>
										</ul>
									</li>
				
								</ul>
							</li>
						</ul>
						
						
						
					</div>
					<div title="数据挖掘" style="padding: 10px;">
						<p>Jae world.</p>
					</div>
					<div title="数据源配置" style="padding: 10px;">
						<p>Jae world.</p>
					</div>
					<div title="后台管理" style="padding: 10px;">
						<p>Jae world.</p>
					</div>
					<!-- <div title="" selected style="padding:10px;"></div> -->
				</div>
				<!--手风琴菜单end-->
			</div>
		</div>
		<!--中间主要区域-->
		 <div data-options="region:'center',split:true,fit:true">
			<div id="mainTabs" class="easyui-tabs" data-options="fit:true">
			</div>
		</div> 
		<!--右侧主要区域-->
		<!-- <div region="east" title="右侧边栏" split="true" style="width: 0px;">
		</div> -->
		<!--页脚-->
		<div region="south" style="text-align: center; height: 50px; overflow:hidden">
			<h3>国网XX电力</h3>
		</div>
		
	
		</div>
	</div>
</body>

</html>


