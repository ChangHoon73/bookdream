select * from history where members_no = 1

history, books, members

select * from history, books, members
where history.books_no = books.no 
and history.members_no = members.no
and history.members_no = 1 