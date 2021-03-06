SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Ordonnancement]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Ordonnancement](
	[Ord_ID] [int] IDENTITY(1,1) NOT NULL,
	[Ord_Designation] [nvarchar](50) NOT NULL,
	[Ord_QteFab] [int] NOT NULL,
	[Ord_Ste] [nvarchar](50) NOT NULL,
	[Ord_CodeClient] [nvarchar](50) NOT NULL,
	[Ord_DelaiCde] [datetime] NOT NULL,
	[Ord_MFab] [datetime] NOT NULL,
	[Ord_DelaiPrv] [datetime] NOT NULL,
	[Ord_DelaiDde] [datetime] NOT NULL,
	[Ord_FamGest] [nvarchar](50) NOT NULL,
	[Ord_NumDossier] [nvarchar](50) NOT NULL,
	[Ord_CodeGPAO] [nvarchar](50) NOT NULL,
	[Ord_IndNomenclature] [nvarchar](50) NOT NULL,
	[Ord_NumSerie] [nvarchar](50) NOT NULL,
	[Ord_ComInterne] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Ordonnancement] PRIMARY KEY CLUSTERED 
(
	[Ord_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BonCommande]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[BonCommande](
	[BCom_ID] [int] IDENTITY(1,1) NOT NULL,
	[BCom_Designation] [nvarchar](50) NOT NULL,
	[BCom_Reference] [nvarchar](50) NOT NULL,
	[BCom_NumDossier] [nvarchar](50) NOT NULL,
	[BCom_Quantite] [int] NOT NULL,
	[BCom_Fournisseur] [nvarchar](50) NOT NULL,
	[BCom_Date] [datetime] NOT NULL,
 CONSTRAINT [PK_Commande] PRIMARY KEY CLUSTERED 
(
	[BCom_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BonExpedition]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[BonExpedition](
	[BExp_ID] [int] IDENTITY(1,1) NOT NULL,
	[BExp_Designation] [nvarchar](50) NOT NULL,
	[BExp_Reference] [nvarchar](50) NOT NULL,
	[BExp_NumDossier] [nvarchar](50) NOT NULL,
	[BExp_Quantite] [int] NOT NULL,
	[Bexp_Client] [nvarchar](50) NOT NULL,
	[BExp_Date] [datetime] NOT NULL,
 CONSTRAINT [PK_BonExpedition] PRIMARY KEY CLUSTERED 
(
	[BExp_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[BonLivraison]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[BonLivraison](
	[Bliv_ID] [int] IDENTITY(1,1) NOT NULL,
	[Bliv_Designation] [nvarchar](50) NOT NULL,
	[Bliv_Reference] [nvarchar](50) NOT NULL,
	[Bliv_NumDossier] [nvarchar](50) NOT NULL,
	[Bliv_Quantite] [int] NOT NULL,
	[Bliv_Fournisseur] [nvarchar](50) NOT NULL,
	[Bliv_Date] [datetime] NOT NULL,
 CONSTRAINT [PK_BonLivraison] PRIMARY KEY CLUSTERED 
(
	[Bliv_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Client]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Client](
	[C_ID] [int] IDENTITY(1,1) NOT NULL,
	[C_Nom] [nvarchar](50) NOT NULL,
	[C_Adresse] [nvarchar](50) NOT NULL,
	[C_Description] [nvarchar](50) NOT NULL,
	[C_Mdp] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Client] PRIMARY KEY CLUSTERED 
(
	[C_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Piece]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Piece](
	[P_ID] [int] IDENTITY(1,1) NOT NULL,
	[P_Nom] [nvarchar](50) NOT NULL,
	[P_CodeBarre] [nvarchar](50) NOT NULL,
	[P_Statut] [bit] NOT NULL,
 CONSTRAINT [PK_Piece] PRIMARY KEY CLUSTERED 
(
	[P_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Assemblage]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Assemblage](
	[A_ID] [int] IDENTITY(1,1) NOT NULL,
	[A_Nom] [nvarchar](50) NOT NULL,
	[A_Ref] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Assemblage] PRIMARY KEY CLUSTERED 
(
	[A_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CritereQualite]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[CritereQualite](
	[CrQ_ID] [int] IDENTITY(1,1) NOT NULL,
	[CrQ_libelle] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_CritereQualite] PRIMARY KEY CLUSTERED 
(
	[CrQ_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Etat_Operation]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Etat_Operation](
	[E_ID] [int] IDENTITY(1,1) NOT NULL,
	[E_Etat] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Etat_Operation] PRIMARY KEY CLUSTERED 
(
	[E_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Lieu]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Lieu](
	[L_ID] [int] IDENTITY(1,1) NOT NULL,
	[L_Nom] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Lieu] PRIMARY KEY CLUSTERED 
(
	[L_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Operateur]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Operateur](
	[O_ID] [int] IDENTITY(1,1) NOT NULL,
	[O_Nom] [nvarchar](50) NOT NULL,
	[O_Prenom] [nvarchar](50) NOT NULL,
	[O_MotDePasse] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Operateur] PRIMARY KEY CLUSTERED 
(
	[O_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Fournisseur]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Fournisseur](
	[F_ID] [int] IDENTITY(1,1) NOT NULL,
	[F_Nom] [nvarchar](50) NOT NULL,
	[F_Adresse] [nvarchar](50) NOT NULL,
	[F_Description] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Fournisseur] PRIMARY KEY CLUSTERED 
(
	[F_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Commande]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Commande](
	[Com_ID] [int] IDENTITY(1,1) NOT NULL,
	[Com_BCom_ID] [int] NOT NULL,
	[Com_F_ID] [int] NOT NULL,
	[Com_P_ID] [int] NOT NULL,
	[Com_Date] [datetime] NOT NULL,
 CONSTRAINT [PK_Commande_1] PRIMARY KEY CLUSTERED 
(
	[Com_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Expedition]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Expedition](
	[Exp_ID] [int] IDENTITY(1,1) NOT NULL,
	[Exp_BExp_ID] [int] NOT NULL,
	[Exp_C_ID] [int] NOT NULL,
	[Exp_A_ID] [int] NOT NULL,
	[Exp_Date] [datetime] NOT NULL,
 CONSTRAINT [PK_Expedition] PRIMARY KEY CLUSTERED 
(
	[Exp_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Livraison]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Livraison](
	[Liv_ID] [int] IDENTITY(1,1) NOT NULL,
	[Liv_Bliv_ID] [int] NOT NULL,
	[Liv_F_ID] [int] NOT NULL,
	[Liv_P_ID] [int] NOT NULL,
	[Liv_Date] [datetime] NOT NULL,
 CONSTRAINT [PK_Livraison] PRIMARY KEY CLUSTERED 
(
	[Liv_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[LocalisationPiece]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[LocalisationPiece](
	[LocP_ID] [int] IDENTITY(1,1) NOT NULL,
	[LocP_Date] [datetime] NOT NULL,
	[LocP_O_ID] [int] NOT NULL,
	[LocP_L_ID] [int] NOT NULL,
	[LocP_P_ID] [int] NOT NULL,
 CONSTRAINT [PK_LocalisationPiece] PRIMARY KEY CLUSTERED 
(
	[LocP_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ActionPiece]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ActionPiece](
	[AP_ID] [int] IDENTITY(1,1) NOT NULL,
	[AP_P_ID] [int] NOT NULL,
	[AP_O_ID] [int] NOT NULL,
	[AP_Op_ID] [int] NOT NULL,
	[AP_L_ID] [int] NOT NULL,
	[AP_Date] [datetime] NOT NULL,
 CONSTRAINT [PK_ActionPiece] PRIMARY KEY CLUSTERED 
(
	[AP_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[LocalisationAssemblage]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[LocalisationAssemblage](
	[LocA_ID] [int] IDENTITY(1,1) NOT NULL,
	[LocA_O_ID] [int] NOT NULL,
	[LocA_Date] [datetime] NOT NULL,
	[LocA_L_ID] [int] NOT NULL,
	[LocA_A_ID] [int] NOT NULL,
 CONSTRAINT [PK_LocalisationAssemblage] PRIMARY KEY CLUSTERED 
(
	[LocA_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ActionAssemblage]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ActionAssemblage](
	[AA_ID] [int] IDENTITY(1,1) NOT NULL,
	[AA_L_ID] [int] NOT NULL,
	[AA_O_ID] [int] NOT NULL,
	[AA_Op_ID] [int] NOT NULL,
	[AA_Date] [datetime] NOT NULL,
	[AA_A_ID] [int] NOT NULL,
 CONSTRAINT [PK_ActionAssemblage] PRIMARY KEY CLUSTERED 
(
	[AA_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ControleQualite]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ControleQualite](
	[CQ_CrQ_ID] [int] NOT NULL,
	[CQ_O_ID] [int] NOT NULL,
	[CQ_A_ID] [int] NOT NULL,
	[CQ_Resultat] [tinyint] NOT NULL,
	[CQ_ID] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_ControleQualite] PRIMARY KEY CLUSTERED 
(
	[CQ_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Operation]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Operation](
	[Op_ID] [int] IDENTITY(1,1) NOT NULL,
	[Op_Libelle] [nvarchar](50) NOT NULL,
	[Op_EO_ID] [int] NOT NULL,
 CONSTRAINT [PK_Operation] PRIMARY KEY CLUSTERED 
(
	[Op_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Commande_BonCommande]') AND parent_object_id = OBJECT_ID(N'[dbo].[Commande]'))
ALTER TABLE [dbo].[Commande]  WITH CHECK ADD  CONSTRAINT [FK_Commande_BonCommande] FOREIGN KEY([Com_BCom_ID])
REFERENCES [dbo].[BonCommande] ([BCom_ID])
GO
ALTER TABLE [dbo].[Commande] CHECK CONSTRAINT [FK_Commande_BonCommande]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Commande_Fournisseur]') AND parent_object_id = OBJECT_ID(N'[dbo].[Commande]'))
ALTER TABLE [dbo].[Commande]  WITH CHECK ADD  CONSTRAINT [FK_Commande_Fournisseur] FOREIGN KEY([Com_F_ID])
REFERENCES [dbo].[Fournisseur] ([F_ID])
GO
ALTER TABLE [dbo].[Commande] CHECK CONSTRAINT [FK_Commande_Fournisseur]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Commande_Piece]') AND parent_object_id = OBJECT_ID(N'[dbo].[Commande]'))
ALTER TABLE [dbo].[Commande]  WITH CHECK ADD  CONSTRAINT [FK_Commande_Piece] FOREIGN KEY([Com_P_ID])
REFERENCES [dbo].[Piece] ([P_ID])
GO
ALTER TABLE [dbo].[Commande] CHECK CONSTRAINT [FK_Commande_Piece]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Expedition_Assemblage]') AND parent_object_id = OBJECT_ID(N'[dbo].[Expedition]'))
ALTER TABLE [dbo].[Expedition]  WITH CHECK ADD  CONSTRAINT [FK_Expedition_Assemblage] FOREIGN KEY([Exp_A_ID])
REFERENCES [dbo].[Assemblage] ([A_ID])
GO
ALTER TABLE [dbo].[Expedition] CHECK CONSTRAINT [FK_Expedition_Assemblage]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Expedition_BonExpedition]') AND parent_object_id = OBJECT_ID(N'[dbo].[Expedition]'))
ALTER TABLE [dbo].[Expedition]  WITH CHECK ADD  CONSTRAINT [FK_Expedition_BonExpedition] FOREIGN KEY([Exp_BExp_ID])
REFERENCES [dbo].[BonExpedition] ([BExp_ID])
GO
ALTER TABLE [dbo].[Expedition] CHECK CONSTRAINT [FK_Expedition_BonExpedition]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Expedition_Client]') AND parent_object_id = OBJECT_ID(N'[dbo].[Expedition]'))
ALTER TABLE [dbo].[Expedition]  WITH CHECK ADD  CONSTRAINT [FK_Expedition_Client] FOREIGN KEY([Exp_C_ID])
REFERENCES [dbo].[Client] ([C_ID])
GO
ALTER TABLE [dbo].[Expedition] CHECK CONSTRAINT [FK_Expedition_Client]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Livraison_BonLivraison]') AND parent_object_id = OBJECT_ID(N'[dbo].[Livraison]'))
ALTER TABLE [dbo].[Livraison]  WITH CHECK ADD  CONSTRAINT [FK_Livraison_BonLivraison] FOREIGN KEY([Liv_Bliv_ID])
REFERENCES [dbo].[BonLivraison] ([Bliv_ID])
GO
ALTER TABLE [dbo].[Livraison] CHECK CONSTRAINT [FK_Livraison_BonLivraison]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Livraison_Fournisseur]') AND parent_object_id = OBJECT_ID(N'[dbo].[Livraison]'))
ALTER TABLE [dbo].[Livraison]  WITH CHECK ADD  CONSTRAINT [FK_Livraison_Fournisseur] FOREIGN KEY([Liv_F_ID])
REFERENCES [dbo].[Fournisseur] ([F_ID])
GO
ALTER TABLE [dbo].[Livraison] CHECK CONSTRAINT [FK_Livraison_Fournisseur]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Livraison_Piece]') AND parent_object_id = OBJECT_ID(N'[dbo].[Livraison]'))
ALTER TABLE [dbo].[Livraison]  WITH CHECK ADD  CONSTRAINT [FK_Livraison_Piece] FOREIGN KEY([Liv_P_ID])
REFERENCES [dbo].[Piece] ([P_ID])
GO
ALTER TABLE [dbo].[Livraison] CHECK CONSTRAINT [FK_Livraison_Piece]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_LocalisationPiece_Lieu]') AND parent_object_id = OBJECT_ID(N'[dbo].[LocalisationPiece]'))
ALTER TABLE [dbo].[LocalisationPiece]  WITH CHECK ADD  CONSTRAINT [FK_LocalisationPiece_Lieu] FOREIGN KEY([LocP_L_ID])
REFERENCES [dbo].[Lieu] ([L_ID])
GO
ALTER TABLE [dbo].[LocalisationPiece] CHECK CONSTRAINT [FK_LocalisationPiece_Lieu]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_LocalisationPiece_Operateur]') AND parent_object_id = OBJECT_ID(N'[dbo].[LocalisationPiece]'))
ALTER TABLE [dbo].[LocalisationPiece]  WITH CHECK ADD  CONSTRAINT [FK_LocalisationPiece_Operateur] FOREIGN KEY([LocP_O_ID])
REFERENCES [dbo].[Operateur] ([O_ID])
GO
ALTER TABLE [dbo].[LocalisationPiece] CHECK CONSTRAINT [FK_LocalisationPiece_Operateur]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_LocalisationPiece_Piece]') AND parent_object_id = OBJECT_ID(N'[dbo].[LocalisationPiece]'))
ALTER TABLE [dbo].[LocalisationPiece]  WITH CHECK ADD  CONSTRAINT [FK_LocalisationPiece_Piece] FOREIGN KEY([LocP_P_ID])
REFERENCES [dbo].[Piece] ([P_ID])
GO
ALTER TABLE [dbo].[LocalisationPiece] CHECK CONSTRAINT [FK_LocalisationPiece_Piece]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Action_Lieu]') AND parent_object_id = OBJECT_ID(N'[dbo].[ActionPiece]'))
ALTER TABLE [dbo].[ActionPiece]  WITH CHECK ADD  CONSTRAINT [FK_Action_Lieu] FOREIGN KEY([AP_L_ID])
REFERENCES [dbo].[Lieu] ([L_ID])
GO
ALTER TABLE [dbo].[ActionPiece] CHECK CONSTRAINT [FK_Action_Lieu]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Action_Operateur]') AND parent_object_id = OBJECT_ID(N'[dbo].[ActionPiece]'))
ALTER TABLE [dbo].[ActionPiece]  WITH CHECK ADD  CONSTRAINT [FK_Action_Operateur] FOREIGN KEY([AP_O_ID])
REFERENCES [dbo].[Operateur] ([O_ID])
GO
ALTER TABLE [dbo].[ActionPiece] CHECK CONSTRAINT [FK_Action_Operateur]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Action_Operation]') AND parent_object_id = OBJECT_ID(N'[dbo].[ActionPiece]'))
ALTER TABLE [dbo].[ActionPiece]  WITH CHECK ADD  CONSTRAINT [FK_Action_Operation] FOREIGN KEY([AP_Op_ID])
REFERENCES [dbo].[Operation] ([Op_ID])
GO
ALTER TABLE [dbo].[ActionPiece] CHECK CONSTRAINT [FK_Action_Operation]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Action_Piece]') AND parent_object_id = OBJECT_ID(N'[dbo].[ActionPiece]'))
ALTER TABLE [dbo].[ActionPiece]  WITH CHECK ADD  CONSTRAINT [FK_Action_Piece] FOREIGN KEY([AP_P_ID])
REFERENCES [dbo].[Piece] ([P_ID])
GO
ALTER TABLE [dbo].[ActionPiece] CHECK CONSTRAINT [FK_Action_Piece]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Localisation_Lieu]') AND parent_object_id = OBJECT_ID(N'[dbo].[LocalisationAssemblage]'))
ALTER TABLE [dbo].[LocalisationAssemblage]  WITH CHECK ADD  CONSTRAINT [FK_Localisation_Lieu] FOREIGN KEY([LocA_L_ID])
REFERENCES [dbo].[Lieu] ([L_ID])
GO
ALTER TABLE [dbo].[LocalisationAssemblage] CHECK CONSTRAINT [FK_Localisation_Lieu]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_LocalisationAssemblage_Assemblage]') AND parent_object_id = OBJECT_ID(N'[dbo].[LocalisationAssemblage]'))
ALTER TABLE [dbo].[LocalisationAssemblage]  WITH CHECK ADD  CONSTRAINT [FK_LocalisationAssemblage_Assemblage] FOREIGN KEY([LocA_A_ID])
REFERENCES [dbo].[Assemblage] ([A_ID])
GO
ALTER TABLE [dbo].[LocalisationAssemblage] CHECK CONSTRAINT [FK_LocalisationAssemblage_Assemblage]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_LocalisationAssemblage_Operateur]') AND parent_object_id = OBJECT_ID(N'[dbo].[LocalisationAssemblage]'))
ALTER TABLE [dbo].[LocalisationAssemblage]  WITH CHECK ADD  CONSTRAINT [FK_LocalisationAssemblage_Operateur] FOREIGN KEY([LocA_O_ID])
REFERENCES [dbo].[Operateur] ([O_ID])
GO
ALTER TABLE [dbo].[LocalisationAssemblage] CHECK CONSTRAINT [FK_LocalisationAssemblage_Operateur]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ActionAssemblage_ActionAssemblage]') AND parent_object_id = OBJECT_ID(N'[dbo].[ActionAssemblage]'))
ALTER TABLE [dbo].[ActionAssemblage]  WITH CHECK ADD  CONSTRAINT [FK_ActionAssemblage_ActionAssemblage] FOREIGN KEY([AA_A_ID])
REFERENCES [dbo].[Assemblage] ([A_ID])
GO
ALTER TABLE [dbo].[ActionAssemblage] CHECK CONSTRAINT [FK_ActionAssemblage_ActionAssemblage]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ActionAssemblage_Lieu]') AND parent_object_id = OBJECT_ID(N'[dbo].[ActionAssemblage]'))
ALTER TABLE [dbo].[ActionAssemblage]  WITH CHECK ADD  CONSTRAINT [FK_ActionAssemblage_Lieu] FOREIGN KEY([AA_L_ID])
REFERENCES [dbo].[Lieu] ([L_ID])
GO
ALTER TABLE [dbo].[ActionAssemblage] CHECK CONSTRAINT [FK_ActionAssemblage_Lieu]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ActionAssemblage_Operateur]') AND parent_object_id = OBJECT_ID(N'[dbo].[ActionAssemblage]'))
ALTER TABLE [dbo].[ActionAssemblage]  WITH CHECK ADD  CONSTRAINT [FK_ActionAssemblage_Operateur] FOREIGN KEY([AA_O_ID])
REFERENCES [dbo].[Operateur] ([O_ID])
GO
ALTER TABLE [dbo].[ActionAssemblage] CHECK CONSTRAINT [FK_ActionAssemblage_Operateur]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ActionAssemblage_Operation]') AND parent_object_id = OBJECT_ID(N'[dbo].[ActionAssemblage]'))
ALTER TABLE [dbo].[ActionAssemblage]  WITH CHECK ADD  CONSTRAINT [FK_ActionAssemblage_Operation] FOREIGN KEY([AA_Op_ID])
REFERENCES [dbo].[Operation] ([Op_ID])
GO
ALTER TABLE [dbo].[ActionAssemblage] CHECK CONSTRAINT [FK_ActionAssemblage_Operation]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ControleQualite_Assemblage]') AND parent_object_id = OBJECT_ID(N'[dbo].[ControleQualite]'))
ALTER TABLE [dbo].[ControleQualite]  WITH CHECK ADD  CONSTRAINT [FK_ControleQualite_Assemblage] FOREIGN KEY([CQ_A_ID])
REFERENCES [dbo].[Assemblage] ([A_ID])
GO
ALTER TABLE [dbo].[ControleQualite] CHECK CONSTRAINT [FK_ControleQualite_Assemblage]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ControleQualite_CritereQualite]') AND parent_object_id = OBJECT_ID(N'[dbo].[ControleQualite]'))
ALTER TABLE [dbo].[ControleQualite]  WITH CHECK ADD  CONSTRAINT [FK_ControleQualite_CritereQualite] FOREIGN KEY([CQ_CrQ_ID])
REFERENCES [dbo].[CritereQualite] ([CrQ_ID])
GO
ALTER TABLE [dbo].[ControleQualite] CHECK CONSTRAINT [FK_ControleQualite_CritereQualite]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ControleQualite_Operateur]') AND parent_object_id = OBJECT_ID(N'[dbo].[ControleQualite]'))
ALTER TABLE [dbo].[ControleQualite]  WITH CHECK ADD  CONSTRAINT [FK_ControleQualite_Operateur] FOREIGN KEY([CQ_O_ID])
REFERENCES [dbo].[Operateur] ([O_ID])
GO
ALTER TABLE [dbo].[ControleQualite] CHECK CONSTRAINT [FK_ControleQualite_Operateur]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Operation_Etat_Operation]') AND parent_object_id = OBJECT_ID(N'[dbo].[Operation]'))
ALTER TABLE [dbo].[Operation]  WITH CHECK ADD  CONSTRAINT [FK_Operation_Etat_Operation] FOREIGN KEY([Op_EO_ID])
REFERENCES [dbo].[Etat_Operation] ([E_ID])
GO
ALTER TABLE [dbo].[Operation] CHECK CONSTRAINT [FK_Operation_Etat_Operation]
