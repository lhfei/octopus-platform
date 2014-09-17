<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户首页</title>
<%@ include file="../commons/taglib.jsp"%>


    <!-- page specific -->
    
    <script type="text/javascript" src="${basePath}/resources/modules/system/all-classes.js"></script>
    
	<script type="text/javascript" src="${basePath}/resources/modules/system/app.js"></script>

   <style type="text/css" media="screen">
        /**
         * Icons
         */

        .summary {
             background-image: url(${basePath}/resources/modules/system/images/details.gif) !important;
        }

        .reading {
             background-image: url(${basePath}/resources/modules/system/images/article.gif) !important;
        }

        .post-go {
            background-image: url(${basePath}/resources/modules/system/images/post_go.gif) !important;
        }

        .tab-new {
            background-image: url(${basePath}/resources/modules/system/images/tab_new.gif) !important;
        }

        .feed-add {
            background-image: url(${basePath}/resources/modules/system/images/rss_add.gif) !important;
        }

        .feed-remove {
            background-image: url(${basePath}/resources/modules/system/images/rss_delete.gif) !important;
        }

        .feed-load {
            background-image: url(${basePath}/resources/modules/system/images/rss_load.gif) !important;
        }

        .details {
            background-image: url(${basePath}/resources/modules/system/images/details.gif) !important;
        }

        .open-all {
            background-image: url(${basePath}/resources/modules/system/images/tabs.gif) !important;
        }

        .feed {
            width: 16px;
            height: 16px;
            background-image: url(${basePath}/resources/modules/system/images/rss.gif) !important;
        }

        /**
         * Other styles
         */
        .feed-picker-url {
            float: left;
            width: 425px;
        }
        .feed-picker-title {
        /*    float: left;*/
            color: #777;
            font-size: 10px;
        }

        .feed-list {
            padding: 0 3px 0 3px;
        }

        .feed-list-item {
            margin-top: 3px;
            padding-left: 20px;
            font-size: 11px;
            line-height: 20px;
            cursor: pointer;
            background: url(${basePath}/resources/modules/system/images/rss.gif) no-repeat 0 2px;
            border: 1px solid #fff;
        }

        .feed-list .x-item-selected {
            font-weight: bold;
            color: #15428B;
            background-color: #DFE8F6;
            border: 1px dotted #A3BAE9;
        }

        .feed-list-item-hover {
            background-color: #eee;
        }

        .topic {
            padding: 2px 0 0 20px;
            background:transparent url(${basePath}/resources/modules/system/images/post.gif) no-repeat;
        }

        .topic b {
            font-family: tahoma, verdana;
            display: block;
            color: #333;
        }

        .author {
            color: #333
        }

        .post-date {
            font-weight:bold;
            color:#333;
        }

        .feed-grid .x-grid-rowbody {
            margin: 5px 20px 10px 25px !important;
            color: #555;
            font-size: 11px;
        }

        /* Preview classes */
        .articlepreview .x-toolbar {
            border-top-width: 1px !important;
        }

        .preview .x-panel-body {
            background:#fff;
            color:#222;
            font:normal 12px tahoma,verdana,arial,sans-serif;
        }

        .preview .x-panel-body p {
            line-height:18px;
            margin:8px 0;
        }

        .preview .x-panel-body ul {
            margin-left:18px;
        }

        .preview .x-panel-body ul li {
            display:list-item;
            list-style-image:none !important;
            list-style-position:outside !important;
            list-style-type:disc !important;
            margin-left:18px;
        }

        .preview .x-panel-body pre, #preview .x-panel-body code {
            background:#f1f1f1;
            display:block;
        }

        .preview .x-panel-body h4.post-author {
            font-weight:normal;
            color:#555;
            font-size:11px;
        }
        .preview .x-panel-body span.post-date {
            font-weight:normal;
            color:#555;
            float:right;
            font-size:11px;
        }
        .preview .x-panel-body div.post-data {
            background:#f1f2f4;
            padding:5px;
            border-bottom:1px solid #dadadb;
        }
        .preview .x-panel-body div.post-body {
            padding:10px;
        }

        .x-tab-bar-body {
            border-width: 1px 1px 0 1px !important;
        }
    </style>
</head>
<body>
	
</body>
</html>
