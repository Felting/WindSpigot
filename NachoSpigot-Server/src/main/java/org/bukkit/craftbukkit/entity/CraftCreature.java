package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

import net.minecraft.server.EntityCreature;

public class CraftCreature extends CraftLivingEntity implements Creature
{
	public CraftCreature(CraftServer server, EntityCreature entity)
	{
		super(server, entity);
	}

	@Override
	public void setTarget(LivingEntity target)
	{
		EntityCreature entity = getHandle();
		if (target == null)
		{
			entity.setGoalTarget(null, null, false);
		} else if (target instanceof CraftLivingEntity)
		{
			entity.setGoalTarget(((CraftLivingEntity) target).getHandle(), null, false);
		}
	}

	@Override
	public CraftLivingEntity getTarget()
	{
		if (getHandle().getGoalTarget() == null)
		{
			return null;
		}

		return (CraftLivingEntity) getHandle().getGoalTarget().getBukkitEntity();
	}

	@Override
	public EntityCreature getHandle()
	{
		return (EntityCreature) entity;
	}

	@Override
	public String toString()
	{
		return "CraftCreature";
	}
}
