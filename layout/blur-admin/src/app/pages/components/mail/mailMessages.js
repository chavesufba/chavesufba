/**
 * @author a.demeshko
 * created on 12/29/15
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.components.mail')
    .service('mailMessages', mailMessages);

  /** @ngInject */
  function mailMessages($sce) {
    var messages = [
      {
        "id": "4563faass",
        "name": "Ivan Machado",
        "subject": "143",
        "date": "2015-08-28T07:57:09",
        "body": $sce.trustAsHtml("<p>Laboratório - Instituto de Matemática</p>"),
        "pic": "img/Nasta.png",
        "email": "petraramsey@mail.com",
        "attachment": "poem.txt",
        "position": "Great Employee",
        "tag": "friend",
        "labels": ['inbox']
      },
      {
        "id": "4563fdfvd",
        "name": "Ivan Machado",
        "subject": "143",
        "date": "2015-11-19T03:30:45",
        "important": false,
        "body": $sce.trustAsHtml("<p>Laboratório - Instituto de Matemática</p>"),
        "pic": "img/Nasta.png",
        "email": "petraramsey@mail.com",
        "position": "Great Employee",
        "tag": "study",
        "labels": ['inbox']
      },
      {
        "id": "4563zxcss",
        "name": "Ivan Machado",
        "subject": "143",
        "date": "2015-10-19T03:30:45",
        "important": false,
        "body": $sce.trustAsHtml("<p>Laboratório - Instituto de Matemática</p>"),
        "pic": "img/Nasta.png",
        "email": "petraramsey@mail.com",
        "position": "Great Employee",
        "tag": "work",
        "labels": ['sent', 'important']
      },
      {
        "id": "8955sddf",
        "name": "Nick Cat",
        "subject": "105",
        "date": "2015-05-05T12:59:45",
        "body": $sce.trustAsHtml("<p>Pavilhão de Aulas da Federação 1</p>"),
        "pic": "img/Nick.png",
        "email": "barlowshort@mail.com",
        "position": "Graphical designer",
        "attachment": "design.psd",
        "tag": "work",
        "labels": ['inbox']
      },
      {
        "id": "8955sdfcc",
        "name": "Nick Cat",
        "subject": "105",
        "date": "2015-07-18T10:19:01",
        "body": $sce.trustAsHtml("<p>Pavilhão de Aulas da Federação 1</p>"),
        "pic": "img/Nick.png",
        "email": "barlowshort@mail.com",
        "position": "Graphical designer",
        "tag": "study",
        "labels": ['inbox']
      },
      {
        "id": "8955asewf",
        "name": "Nick Cat",
        "subject": "105",
        "date": "2015-09-23T03:04:10",
        "body": $sce.trustAsHtml("<p>Pavilhão de Aulas da Federação 1</p>"),
        "pic": "img/Nick.png",
        "email": "barlowshort@mail.com",
        "position": "Graphical designer",
        "tag": "work",
        "labels": ['inbox', 'important']
      },
      {
        "id": "2334uudsa",
        "name": "Kostya Danovsky",
        "subject": "01",
        "date": "2015-11-22T10:05:09",
        "body": $sce.trustAsHtml("<p>Pavilhão de Aulas da Federação 1</p>"),
        "pic": "img/Kostya.png",
        "email": "schwart@mail.com",
        "position": "Technical Chef",
        "attachment": "file.doc",
        "tag": "family",
        "labels": ['inbox', 'important']
      },
      {
        "id": "2334aefvv",
        "name": "Kostya Danovsky",
        "subject": "01",
        "date": "2015-06-22T06:26:10",
        "body": $sce.trustAsHtml("<p>Pavilhão de Aulas da Federação 1</p>"),
        "pic": "img/Kostya.png",
        "email": "schwart@mail.com",
        "position": "Technical Chef",
        "tag": "family",
        "labels": ['inbox', 'important']
      },
      {
        "id": "2334cvdss",
        "name": "Kostya Danovsky",
        "subject": "01",
        "date": "2015-06-22T06:26:10",
        "body": $sce.trustAsHtml("<p>Pavilhão de Aulas da Federação 1</p>"),
        "pic": "img/Kostya.png",
        "email": "schwart@mail.com",
        "position": "Technical Chef",
        "tag": "study",
        "labels": ['trash']
      },
      {
        "id": "8223xzxfn",
        "name": "Andrey Hrabouski",
        "subject": "Skype moji",
        "date": "2015-07-16T06:47:53",
        "body": $sce.trustAsHtml("<p>Pavilhão de Aulas da Federação 1</p>"),
        "pic": "img/Andrey.png",
        "email": "lakeishaphillips@mail.com",
        "position": "Mobile Developer",
        "tag": 'family',
        "labels": ['trash']
      },
      {
        "id": "8223sdffn",
        "name": "Andrey Hrabouski",
        "subject": "My App",
        "date": "2015-06-20T07:05:02",
        "body": $sce.trustAsHtml("<p>Pavilhão de Aulas da Federação 1</p>"),
        "pic": "img/Andrey.png",
        "email": "lakeishaphillips@mail.com",
        "position": "Mobile Developer",
        "tag": 'family',
        "labels": ['spam']
      },
      {
        "id": "9391xdsff",
        "name": "Vlad Lugovsky",
        "subject": "Cool",
        "date": "2015-03-31T11:52:58",
        "body": $sce.trustAsHtml("<p>Pavilhão de Aulas da Federação 1</p>"),
        "pic": "img/Vlad.png",
        "email": "carlsongoodman@mail.com",
        "position": "Fullstack man",
        "tag": "study",
        "labels": ['draft']
      },
      {
        "id": "8223xsdaa",
        "name": "Andrey Hrabouski",
        "subject": "Car rent",
        "date": "2015-02-25T10:58:58",
        "body": $sce.trustAsHtml("<p>Pavilhão de Aulas da Federação 1</p>"),
        "pic": "img/Andrey.png",
        "email": "lakeishaphillips@mail.com",
        "position": "Mobile Developer",
        "tag": "family",
        "labels": ['draft']
      },
      {
        "id": "9391xdsff",
        "name": "Vlad Lugovsky",
        "subject": "What next",
        "date": "2015-03-31T11:52:58",
        "body": $sce.trustAsHtml("<p>Pavilhão de Aulas da Federação 1</p>"),
        "pic": "img/Vlad.png",
        "email": "carlsongoodman@mail.com",
        "position": "Fullstack man",
        "tag": "study",
        "labels": ['sent']
      }
    ].sort(function (a, b) {
        if (a.date > b.date) return 1;
        if (a.date < b.date) return -1;
      }).reverse();
    var tabs = [{
      label: 'inbox',
      name: 'Inbox',
      newMails: 7
    }, {
      label: 'sent',
      name: 'Sent Mail'
    }, {
      label: 'important',
      name: 'Important'
    }, {
      label: 'draft',
      name: 'Draft',
      newMails: 2
    }, {
      label: 'spam',
      name: 'Spam'
    }, {
      label: 'trash',
      name: 'Trash'
    }];

    return{
      getTabs : function(){
        return tabs
      },
      getMessagesByLabel : function(label){
        return messages.filter(function(m){
          return m.labels.indexOf(label) != -1;
        });
      },
      getMessageById : function(id){
        return messages.filter(function(m){
          return m.id == id;
        })[0];
      }
    }

  }

})();