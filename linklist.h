#include <stdio.h>
#include <stdlib.h>
typedef  int data;
typedef struct node {
    data a;          
    struct node *next;   
}*list; 
 
list creat()
{
	list head,r,s;
	data x;
	head =NULL;
	printf("请输入链表");
	scanf("%d",&x);
	while(x!=0)
	{
		s=(list)malloc(sizeof(struct node));
		s->a=x;
		if(head==NULL)
		{
			head=s;
		}
		else
			r->next=s;
		r=s;
			scanf("%d",&x);
	}
	if(r)
		r->next=NULL;
	return head;
}

void print(list l)
{
	list p;
	int i=0;
	p=(list)malloc(sizeof(struct node));
	p=l->next;
	p->a=l->next->a;
	printf("链表是:");
	while(p)
	{
		printf("%d",p->a);
		printf(" ");
		p=p->next;
	}
	printf("\n");
}
