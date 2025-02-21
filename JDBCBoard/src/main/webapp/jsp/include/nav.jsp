<%@ page contentType="text/html; charset=UTF-8"%>

<nav>
    <ul class="nav nav-tabs">
        <li class="nav-item" role="presentation">
            <a href="/selectMember.do" class="nav-link active" id="home-tab" role="tab" aria-controls="home-tab-pane" aria-selected="true" onclick="navigateAndActivateTab(event, 'home-tab')">회원관리</a>
        </li>
        <li class="nav-item">
            <a href="/selectBoard.do" class="nav-link" id="board-tab" role="tab" aria-controls="board-tab-pane" aria-selected="false" onclick="navigateAndActivateTab(event, 'board-tab')">게시판관리</a>
        </li>
        <li class="nav-item">
            <a href="/selectArticle.do" class="nav-link" id="article-tab" role="tab" aria-controls="article-tab-pane" aria-selected="false" onclick="navigateAndActivateTab(event, 'article-tab')">게시물관리</a>
        </li>
    </ul>
</nav>