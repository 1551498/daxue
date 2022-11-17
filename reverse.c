#include"linklist.h"
void reverse(list l)
{
	list p,r;
	p=(list)malloc(sizeof(struct node));
	r=(list)malloc(sizeof(struct node));
	p=l->next;
	l->next=NULL;
	while(p!=0)
	{
		r=p->next;
		p->next=l->next;
		l->next=p;
		p=r;
	}
}

void init(list l)
{
	l=(list)malloc(sizeof(struct node));
	l=NULL;
}

int main()
{
	list head,p;
	head=(list)malloc(sizeof(struct node));
	p=(list)malloc(sizeof(struct node));
    p=creat();
	
	head->next=p;
	printf("当前链表:");
	print(head);
	printf("倒置后:");
	reverse(head);
	print(head);
	while(1);
	return 0;
}


 